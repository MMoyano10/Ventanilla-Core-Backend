package ec.edu.espe.web.repository;

import ec.edu.espe.web.model.UsuarioWeb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioWebRepository extends JpaRepository<UsuarioWeb, Integer> {

    Optional<UsuarioWeb> findByNombreUsuario(String nombreUsuario);

    Optional<UsuarioWeb> findByEmailContacto(String emailContacto);

    Optional<UsuarioWeb> findByClienteId(Integer clienteId);
}