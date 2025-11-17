package ec.edu.espe.web.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import ec.edu.espe.web.dto.CuentaWebResponse;
import ec.edu.espe.web.dto.MovimientoWebResponse;
import ec.edu.espe.web.dto.RespuestaCoreDTO;
import ec.edu.espe.web.dto.TransaccionCoreDTO;
import ec.edu.espe.web.exception.SystemException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@RequiredArgsConstructor
public class CoreClient {

    private final RestTemplate restTemplate;

    @Value("${core.base.url:http://localhost:85}")
    private String coreBaseUrl;

    @Value("${core.transacciones.endpoint:/api/core/transacciones}")
    private String transaccionesEndpoint;

    @Value("${core.cuentas.endpoint:/api/core/cuentas}")
    private String cuentasEndpoint;

    public RespuestaCoreDTO enviarTransaccionAlCore(TransaccionCoreDTO transaccionCoreDTO) {
        String url = coreBaseUrl + transaccionesEndpoint;

        log.info("Enviando transacción al CORE: {} - Monto: {} - Canal: {}",
                transaccionCoreDTO.getTipoTransaccion(),
                transaccionCoreDTO.getMonto(),
                transaccionCoreDTO.getCanal());

        try {
            ResponseEntity<RespuestaCoreDTO> response = restTemplate.postForEntity(
                    url,
                    transaccionCoreDTO,
                    RespuestaCoreDTO.class);

            if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
                RespuestaCoreDTO respuesta = response.getBody();
                log.info("Respuesta recibida del CORE - Exitoso: {}, Mensaje: {}",
                        respuesta != null && respuesta.isExitoso(), 
                        respuesta != null ? respuesta.getMensaje() : "SIN CUERPO");
                return respuesta;
            } else {
                log.error("Error en respuesta del CORE. Status: {}", response.getStatusCode());
                throw new SystemException("Error al comunicarse con el CORE. Status: " + response.getStatusCode());
            }

        } catch (RestClientException e) {
            log.error("Error de comunicación con el CORE en URL: {}", url, e);

            RespuestaCoreDTO respuestaError = new RespuestaCoreDTO();
            respuestaError.setExitoso(false);
            respuestaError.setMensaje("Error de comunicación con el CORE: " + e.getMessage());
            respuestaError.setCodigoError("COMM_ERROR");

            return respuestaError;
        }
    }

    public List<CuentaWebResponse> listarCuentas(Integer clienteId) {
        String url = coreBaseUrl + cuentasEndpoint + "?clienteId=" + clienteId;
        log.info("Consultando cuentas del cliente {} en CORE: {}", clienteId, url);

        try {
            ResponseEntity<CuentaWebResponse[]> response = restTemplate.getForEntity(
                    url,
                    CuentaWebResponse[].class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return Arrays.asList(response.getBody());
            } else {
                log.warn("Respuesta vacía o no OK al consultar cuentas. Status: {}", response.getStatusCode());
                return Collections.emptyList();
            }
        } catch (RestClientException e) {
            log.error("Error al consultar cuentas en CORE", e);
            throw new SystemException("No se pudieron obtener las cuentas desde el CORE: " + e.getMessage());
        }
    }


    public CuentaWebResponse obtenerCuenta(String numeroCuenta) {
        String url = coreBaseUrl + cuentasEndpoint + "/" + numeroCuenta;
        log.info("Consultando detalle de cuenta {} en CORE: {}", numeroCuenta, url);

        try {
            ResponseEntity<CuentaWebResponse> response = restTemplate.getForEntity(
                    url,
                    CuentaWebResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return response.getBody();
            } else {
                log.error("Cuenta no encontrada o error en CORE. Status: {}", response.getStatusCode());
                throw new SystemException("No se pudo obtener el detalle de la cuenta desde el CORE");
            }
        } catch (RestClientException e) {
            log.error("Error al consultar detalle de cuenta en CORE", e);
            throw new SystemException("No se pudo obtener el detalle de la cuenta desde el CORE: " + e.getMessage());
        }
    }

    public List<MovimientoWebResponse> listarMovimientosCuenta(String numeroCuenta) {
        String url = coreBaseUrl + cuentasEndpoint + "/" + numeroCuenta + "/movimientos";
        log.info("Consultando movimientos de cuenta {} en CORE: {}", numeroCuenta, url);

        try {
            ResponseEntity<MovimientoWebResponse[]> response = restTemplate.getForEntity(
                    url,
                    MovimientoWebResponse[].class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return Arrays.asList(response.getBody());
            } else {
                log.warn("Respuesta vacía o no OK al consultar movimientos. Status: {}", response.getStatusCode());
                return Collections.emptyList();
            }
        } catch (RestClientException e) {
            log.error("Error al consultar movimientos en CORE", e);
            throw new SystemException("No se pudieron obtener los movimientos desde el CORE: " + e.getMessage());
        }
    }
}
