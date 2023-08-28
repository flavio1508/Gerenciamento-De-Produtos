package br.teste.produtos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.teste.produtos.dtos.AdministradorResponseDTO;
import br.teste.produtos.dtos.LoginDTO;
import br.teste.produtos.services.AuthService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/autenticacao" }, produces = { "application/json" })
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping(path = { "/entrar" })
    public ResponseEntity<AdministradorResponseDTO> autenticar(@Valid @RequestBody LoginDTO loginRequest) {
        AdministradorResponseDTO responseDTO = authService.loginAdministrador(loginRequest.getEmail(),
                loginRequest.getSenha());
        return ResponseEntity.ok(responseDTO);
    }
}
