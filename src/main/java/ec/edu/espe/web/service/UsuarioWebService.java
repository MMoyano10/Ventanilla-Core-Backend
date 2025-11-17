package ec.edu.espe.web.service;

import ec.edu.espe.web.dto.LoginWebRequest;
import ec.edu.espe.web.dto.LoginWebResponse;
import ec.edu.espe.web.enums.EstadoUsuarioWeb;
import ec.edu.espe.web.model.UsuarioWeb;
import ec.edu.espe.web.repository.UsuarioWebRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class UsuarioWebService {

    private final UsuarioWebRepository usuarioWebRepository;

    public UsuarioWebService(UsuarioWebRepository usuarioWebRepository) {
        this.usuarioWebRepository = usuarioWebRepository;
    }

    public LoginWebResponse login(LoginWebRequest request) {
        UsuarioWeb usuario = usuarioWebRepository
                .findByNombreUsuario(request.getNombreUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario o contraseña incorrectos"));

        if (usuario.getEstado() != EstadoUsuarioWeb.ACTIVO) {
            throw new IllegalArgumentException("Usuario no se encuentra activo en el sistema");
        }

        if (!request.getPassword().equals(usuario.getHashPassword())) {
            throw new IllegalArgumentException("Usuario o contraseña incorrectos");
        }

        usuario.setUltimoAcceso(OffsetDateTime.now());
        usuarioWebRepository.save(usuario);

        return new LoginWebResponse(
                usuario.getId(),
                usuario.getClienteId(),
                usuario.getNombreUsuario(),
                usuario.getEmailContacto(),
                usuario.getUltimoAcceso()
        );
    }
}
