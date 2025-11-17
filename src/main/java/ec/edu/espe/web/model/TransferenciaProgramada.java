package ec.edu.espe.web.model;

import ec.edu.espe.web.enums.EstadoTransferenciaProgramada;
import ec.edu.espe.web.enums.FrecuenciaTransferencia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "TransferenciasProgramadas", schema = "web")
public class TransferenciaProgramada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clienteId", nullable = false)
    private Integer clienteId;

    @Column(name = "cuentaOrigenId", nullable = false)
    private Integer cuentaOrigenId;

    @Column(name = "numeroCuentaDestino", nullable = false, length = 12)
    private String numeroCuentaDestino;

    @Column(name = "monto", nullable = false, precision = 18, scale = 2)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "frecuencia", nullable = false, length = 15)
    private FrecuenciaTransferencia frecuencia;

    @Column(name = "proximaEjecucion", nullable = false)
    private LocalDate proximaEjecucion;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 10)
    private EstadoTransferenciaProgramada estado = EstadoTransferenciaProgramada.ACTIVA;

    @Column(name = "fechaCreacion", nullable = false)
    private OffsetDateTime fechaCreacion = OffsetDateTime.now();

    public TransferenciaProgramada() {
    }

    public TransferenciaProgramada(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferenciaProgramada that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
