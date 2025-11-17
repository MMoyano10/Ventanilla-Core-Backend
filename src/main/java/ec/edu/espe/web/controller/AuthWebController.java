package ec.edu.espe.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.web.dto.LoginWebRequest;
import ec.edu.espe.web.dto.LoginWebResponse;
import ec.edu.espe.web.service.UsuarioWebService;

@RestController
@RequestMapping("/api/web/auth")
@CrossOrigin(origins = "*")
public class AuthWebController {

    private final UsuarioWebService usuarioWebService;

    public AuthWebController(UsuarioWebService usuarioWebService) {
        this.usuarioWebService = usuarioWebService;
    }

    /**
     * POST /api/web/auth/login
     */
    @PostMapping("/login")
    public ResponseEntity<LoginWebResponse> login(@RequestBody LoginWebRequest request) {
        LoginWebResponse response = usuarioWebService.login(request);
        return ResponseEntity.ok(response);
    }
}
