package ec.edu.espe.web.dto;

import java.math.BigDecimal;

public class TransaccionCoreDTO {

    private String tipoTransaccion;
    private BigDecimal monto;
    private String canal;
    private String descripcion;
    private String numeroCuentaOrigen;
    private String numeroCuentaDestino;
    private Integer clienteId;

    public TransaccionCoreDTO() {
    }

    public TransaccionCoreDTO(String tipoTransaccion, BigDecimal monto, String canal,
                              String descripcion, String numeroCuentaOrigen,
                              String numeroCuentaDestino, Integer clienteId) {
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
        this.canal = canal;
        this.descripcion = descripcion;
        this.numeroCuentaOrigen = numeroCuentaOrigen;
        this.numeroCuentaDestino = numeroCuentaDestino;
        this.clienteId = clienteId;
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

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
        this.numeroCuentaOrigen = numeroCuentaOrigen;
    }

    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(String numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
