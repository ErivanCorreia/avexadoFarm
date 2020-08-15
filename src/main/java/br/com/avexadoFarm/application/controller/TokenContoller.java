package br.com.avexadoFarm.application.controller;

import br.com.avexadoFarm.infrastructure.security.service.AuthenticationServiceImpl;
import br.com.avexadoFarm.presentation.dto.usuario.UsuarioAuthenticationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("/tokens")
public class TokenContoller {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @PostMapping
    public ResponseEntity<String> autenticar(
            @RequestBody UsuarioAuthenticationDTO usuarioAuthenticationDTO) {
        String token = authenticationService.authenticate(usuarioAuthenticationDTO);
        return ResponseEntity.ok(token);
    }
}
