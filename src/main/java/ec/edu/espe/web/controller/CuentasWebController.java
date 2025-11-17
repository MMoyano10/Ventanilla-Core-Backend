package ec.edu.espe.web.controller;

import ec.edu.espe.web.dto.*;
import ec.edu.espe.web.service.CuentasWebService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/web/cuentas")
@CrossOrigin(origins = "*")
public class CuentasWebController {

    private final CuentasWebService cuentasWebService;

    public CuentasWebController(CuentasWebService cuentasWebService) {
        this.cuentasWebService = cuentasWebService;
    }

    /**
     * GET /api/web/cuentas?clienteId=10
     */
    @GetMapping
    public ResponseEntity<List<CuentaWebResponse>> obtenerCuentas(
            @RequestParam Integer clienteId) {

        return ResponseEntity.ok(cuentasWebService.obtenerCuentasPorCliente(clienteId));
    }

    /**
     * GET /api/web/cuentas/{numeroCuenta}
     */
    @GetMapping("/{numeroCuenta}")
    public ResponseEntity<CuentaWebResponse> obtenerDetalleCuenta(
            @PathVariable String numeroCuenta) {

        return ResponseEntity.ok(cuentasWebService.obtenerDetalleCuenta(numeroCuenta));
    }

    /**
     * GET /api/web/cuentas/{numeroCuenta}/movimientos
     */
    @GetMapping("/{numeroCuenta}/movimientos")
    public ResponseEntity<List<MovimientoWebResponse>> obtenerMovimientos(
            @PathVariable String numeroCuenta) {

        return ResponseEntity.ok(cuentasWebService.obtenerMovimientos(numeroCuenta));
    }

    /**
     * POST /api/web/cuentas/transferencias
     */
    @PostMapping("/transferencias")
    public ResponseEntity<TransferenciaWebResponse> transferir(
            @RequestBody TransferenciaWebRequest request) {

        return ResponseEntity.ok(cuentasWebService.realizarTransferencia(request));
    }
}
