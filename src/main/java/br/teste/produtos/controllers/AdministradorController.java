package br.teste.produtos.controllers;

import javax.naming.NameNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.teste.produtos.dtos.AdministradorRequestDTO;
import br.teste.produtos.dtos.AdministradorResponseDTO;
import br.teste.produtos.models.Administrador;
import br.teste.produtos.repository.AdministradorRepository;
import br.teste.produtos.services.AdministradorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "/api/v1/administrador" }, produces = { "application/json" })
public class AdministradorController {
        private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @Autowired
    private AdministradorRepository administradorRepository;

    @Operation(summary = "Cadastrar um novo administrador")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<AdministradorResponseDTO> cadastrar(
            @RequestBody @Valid AdministradorRequestDTO administradorRequestDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.cadastrar(administradorRequestDTO));
    }

    @Operation(summary = "Buscar um administrador pelo seu id")
    @ApiResponse(responseCode = "200", description = "Retorna o administrador solicitado")
    @GetMapping(path = "/{id}")
    public ResponseEntity<AdministradorResponseDTO> buscarPorId(@PathVariable Long id) throws NameNotFoundException {
        return ResponseEntity.ok(administradorService.buscarPorId(id));
    }

    @Operation(summary = "Altera os dados de um administrador cadastrado")
    @ApiResponse(responseCode = "200")
    @PutMapping(path = "/{id}")
    public ResponseEntity<AdministradorResponseDTO> alterarDadosDoAdministrador(
            @RequestBody @Valid AdministradorRequestDTO administradorRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(administradorService.alterarAdministrador(administradorRequestDTO, id));
    }

    @DeleteMapping(path = "/{id}")
    public void remover(@PathVariable Long id) {
        administradorRepository.deleteById(id);
    }
}
