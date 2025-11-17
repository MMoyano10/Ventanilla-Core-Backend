package ec.edu.espe.web.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransferenciaWebResponse {

    private String codigoTransaccion;
    private OffsetDateTime fecha;
    private BigDecimal saldoDisponibleOrigen;
    private BigDecimal saldoDisponibleDestino;

    public TransferenciaWebResponse() {
    }

    public TransferenciaWebResponse(String codigoTransaccion, OffsetDateTime fecha,
                                    BigDecimal saldoDisponibleOrigen, BigDecimal saldoDisponibleDestino) {
        this.codigoTransaccion = codigoTransaccion;
        this.fecha = fecha;
        this.saldoDisponibleOrigen = saldoDisponibleOrigen;
        this.saldoDisponibleDestino = saldoDisponibleDestino;
    }

    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public OffsetDateTime getFecha() {
        return fecha;
    }

    public void setFecha(OffsetDateTime fecha) {
        this.fecha = fecha;
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
