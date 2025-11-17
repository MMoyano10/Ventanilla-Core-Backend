package ec.edu.espe.web.repository;

import ec.edu.espe.web.enums.EstadoTransferenciaProgramada;
import ec.edu.espe.web.model.TransferenciaProgramada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaProgramadaRepository extends JpaRepository<TransferenciaProgramada, Integer> {

    List<TransferenciaProgramada> findByClienteId(Integer clienteId);

    List<TransferenciaProgramada> findByClienteIdAndEstado(Integer clienteId, EstadoTransferenciaProgramada estado);

    List<TransferenciaProgramada> findByEstadoAndProximaEjecucionLessThanEqual(
            EstadoTransferenciaProgramada estado,
            LocalDate fecha
    );
}
