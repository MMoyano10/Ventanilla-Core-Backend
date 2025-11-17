package ec.edu.espe.web.repository;

import ec.edu.espe.web.enums.EstadoBeneficiarioWeb;
import ec.edu.espe.web.model.BeneficiarioWeb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficiarioWebRepository extends JpaRepository<BeneficiarioWeb, Integer> {

    List<BeneficiarioWeb> findByClienteId(Integer clienteId);

    List<BeneficiarioWeb> findByClienteIdAndEstado(Integer clienteId, EstadoBeneficiarioWeb estado);
}
