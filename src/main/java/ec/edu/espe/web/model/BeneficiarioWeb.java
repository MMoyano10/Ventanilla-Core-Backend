package ec.edu.espe.web.model;

import ec.edu.espe.web.enums.EstadoBeneficiarioWeb;
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
@Table(name = "BeneficiariosWeb", schema = "web")
public class BeneficiarioWeb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clienteId", nullable = false)
    private Integer clienteId;

    @Column(name = "alias", nullable = false, length = 60)
    private String alias;

    @Column(name = "numeroCuentaDestino", nullable = false, length = 12)
    private String numeroCuentaDestino;

    @Column(name = "tipoIdentificacion", length = 10)
    private String tipoIdentificacion;

    @Column(name = "numeroIdentificacion", length = 13)
    private String numeroIdentificacion;

    @Column(name = "entidadBancariaId")
    private Integer entidadBancariaId;

    @Column(name = "esPropio", nullable = false)
    private Boolean esPropio = Boolean.FALSE;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 10)
    private EstadoBeneficiarioWeb estado = EstadoBeneficiarioWeb.ACTIVO;

    @Column(name = "fechaRegistro", nullable = false)
    private OffsetDateTime fechaRegistro = OffsetDateTime.now();

    public BeneficiarioWeb() {
    }

    public BeneficiarioWeb(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficiarioWeb that = (BeneficiarioWeb) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
