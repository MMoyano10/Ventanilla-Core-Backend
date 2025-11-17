package ec.edu.espe.web.dto;

import java.time.OffsetDateTime;

public class LoginWebResponse {

    private Integer usuarioWebId;
    private Integer clienteId;
    private String nombreUsuario;
    private String emailContacto;
    private OffsetDateTime ultimoAcceso;

    public LoginWebResponse() {
    }

    public LoginWebResponse(Integer usuarioWebId,
                            Integer clienteId,
                            String nombreUsuario,
                            String emailContacto,
                            OffsetDateTime ultimoAcceso) {
        this.usuarioWebId = usuarioWebId;
        this.clienteId = clienteId;
        this.nombreUsuario = nombreUsuario;
        this.emailContacto = emailContacto;
        this.ultimoAcceso = ultimoAcceso;
    }

    public Integer getUsuarioWebId() {
        return usuarioWebId;
    }

    public void setUsuarioWebId(Integer usuarioWebId) {
        this.usuarioWebId = usuarioWebId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    public OffsetDateTime getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(OffsetDateTime ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }
}
