package ec.edu.espe.web.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class RespuestaCoreDTO {

    private boolean exitoso;
    private String mensaje;
    private String codigoError;
    private String codigoTransaccion;
    private OffsetDateTime fechaTransaccion;
    private BigDecimal saldoDisponibleOrigen;
    private BigDecimal saldoDisponibleDestino;

    public RespuestaCoreDTO() {
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public OffsetDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(OffsetDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public BigDecimal getSaldoDisponibleOrigen() {
        return saldoDisponibleOrigen;
    }

    public void setSaldoDisponibleOrigen(BigDecimal saldoDisponibleOrigen) {
        this.saldoDisponibleOrigen = saldoDisponibleOrigen;
    }

    public BigDecimal getSaldoDisponibleDestino() {
        return saldoDisponibleDestino;
    }

    public void setSaldoDisponibleDestino(BigDecimal saldoDisponibleDestino) {
        this.saldoDisponibleDestino = saldoDisponibleDestino;
    }
}
