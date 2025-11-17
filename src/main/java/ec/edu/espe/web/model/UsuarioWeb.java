package ec.edu.espe.web.model;

import ec.edu.espe.web.enums.EstadoUsuarioWeb;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "UsuariosWeb", schema = "web")
public class UsuarioWeb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clienteId", nullable = false)
    private Integer clienteId;

    @Column(name = "nombreUsuario", nullable = false, unique = true, length = 60)
    private String nombreUsuario;

    @Column(name = "hashPassword", nullable = false, length = 255)
    private String hashPassword;

    @Column(name = "emailContacto", nullable = false, unique = true, length = 120)
    private String emailContacto;

    @Column(name = "telefonoMovil", length = 20)
    private String telefonoMovil;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 10)
    private EstadoUsuarioWeb estado = EstadoUsuarioWeb.ACTIVO;

    @Column(name = "fechaRegistro", nullable = false)
    private OffsetDateTime fechaRegistro = OffsetDateTime.now();

    @Column(name = "ultimoAcceso")
    private OffsetDateTime ultimoAcceso;

    public UsuarioWeb() {
    }

    public UsuarioWeb(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioWeb that = (UsuarioWeb) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
