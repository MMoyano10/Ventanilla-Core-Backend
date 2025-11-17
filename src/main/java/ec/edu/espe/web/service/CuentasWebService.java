package ec.edu.espe.web.service;

import ec.edu.espe.web.client.CoreClient;
import ec.edu.espe.web.dto.*;
import ec.edu.espe.web.exception.SystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentasWebService {

    private final CoreClient coreClient;

    public CuentasWebService(CoreClient coreClient) {
        this.coreClient = coreClient;
    }

    public List<CuentaWebResponse> obtenerCuentasPorCliente(Integer clienteId) {
        return coreClient.listarCuentas(clienteId);
    }

    public CuentaWebResponse obtenerDetalleCuenta(String numeroCuenta) {
        return coreClient.obtenerCuenta(numeroCuenta);
    }

    public List<MovimientoWebResponse> obtenerMovimientos(String numeroCuenta) {
        return coreClient.listarMovimientosCuenta(numeroCuenta);
    }

    public TransferenciaWebResponse realizarTransferencia(TransferenciaWebRequest request) {
        TransaccionCoreDTO transaccionCoreDTO = new TransaccionCoreDTO();
        transaccionCoreDTO.setTipoTransaccion("TRANSFERENCIA");
        transaccionCoreDTO.setCanal("WEB");
        transaccionCoreDTO.setMonto(request.getMonto());
        transaccionCoreDTO.setDescripcion(request.getDescripcion());
        transaccionCoreDTO.setNumeroCuentaOrigen(request.getCuentaOrigen());
        transaccionCoreDTO.setNumeroCuentaDestino(request.getCuentaDestino());

        RespuestaCoreDTO respuestaCore = coreClient.enviarTransaccionAlCore(transaccionCoreDTO);

        if (!respuestaCore.isExitoso()) {
            throw new SystemException("Transacción rechazada por el CORE: " + respuestaCore.getMensaje());
        }

        TransferenciaWebResponse response = new TransferenciaWebResponse();
        response.setCodigoTransaccion(respuestaCore.getCodigoTransaccion());
        response.setFecha(respuestaCore.getFechaTransaccion());
        response.setSaldoDisponibleOrigen(respuestaCore.getSaldoDisponibleOrigen());
        response.setSaldoDisponibleDestino(respuestaCore.getSaldoDisponibleDestino());

        return response;
    }
}
