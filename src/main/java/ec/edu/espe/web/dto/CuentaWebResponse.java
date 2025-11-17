package ec.edu.espe.web.dto;

import java.math.BigDecimal;

public class CuentaWebResponse {

    private Integer cuentaId;
    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoDisponible;
    private BigDecimal saldoContable;
    private String estado;

    public CuentaWebResponse() {
    }

    public CuentaWebResponse(Integer cuentaId, String numeroCuenta, String tipoCuenta,
                             BigDecimal saldoDisponible, BigDecimal saldoContable, String estado) {
        this.cuentaId = cuentaId;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoDisponible = saldoDisponible;
        this.saldoContable = saldoContable;
        this.estado = estado;
    }

    public Integer getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(Integer cuentaId) {
        this.cuentaId = cuentaId;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public BigDecimal getSaldoContable() {
        return saldoContable;
    }

    public void setSaldoContable(BigDecimal saldoContable) {
        this.saldoContable = saldoContable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}