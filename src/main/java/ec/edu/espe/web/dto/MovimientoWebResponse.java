package ec.edu.espe.web.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class MovimientoWebResponse {

    private OffsetDateTime fecha;
    private String tipoTransaccion;
    private BigDecimal monto;
    private String descripcion;
    private BigDecimal saldoPosterior;
    private String canal;

    public MovimientoWebResponse() {
    }

    public MovimientoWebResponse(OffsetDateTime fecha, String tipoTransaccion, BigDecimal monto,
                                 String descripcion, BigDecimal saldoPosterior, String canal) {
        this.fecha = fecha;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.descripcion = descripcion;
        this.saldoPosterior = saldoPosterior;
        this.canal = canal;
    }

    public OffsetDateTime getFecha() {
        return fecha;
    }

    public void setFecha(OffsetDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getSaldoPosterior() {
        return saldoPosterior;
    }

    public void setSaldoPosterior(BigDecimal saldoPosterior) {
        this.saldoPosterior = saldoPosterior;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }
}
