package br.teste.produtos.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.teste.produtos.dtos.ProdutoDigitalRequestDTO;
import br.teste.produtos.dtos.ProdutoDigitalResponseDTO;
import br.teste.produtos.models.Produto;
import br.teste.produtos.models.ProdutoDigital;
import br.teste.produtos.services.ProdutoDigitalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = { "api/v1/produtosDigitais" }, produces = { "application/json" })
public class ProdutoDigitalController {
    private final ProdutoDigitalService produtoDigitalService;

    public ProdutoDigitalController(ProdutoDigitalService produtoDigitalService) {
        this.produtoDigitalService = produtoDigitalService;
    }

    @Operation(summary = "Cadastrar um novo produtoDigital")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<ProdutoDigitalResponseDTO> cadastrarProdutoDigital(
            @RequestBody @Valid ProdutoDigitalRequestDTO produtoDigitalRequestDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoDigitalService.cadastrar(produtoDigitalRequestDTO));
    }

    @DeleteMapping(path = "/{id}")
    public void remover(@PathVariable Long id) {
        produtoDigitalService.deletar(id);
    }

    @Operation(summary = "Buscar uma lista dos produtosDigitais")
    @ApiResponse(responseCode = "200", description = "Lista de produtosDigitais cadastrados")
    @GetMapping
    public ResponseEntity<Collection<ProdutoDigitalResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(produtoDigitalService.buscarTodas());
    }

    @Operation(summary = "Buscar um produtoDigital pelo seu id")
    @ApiResponse(responseCode = "200")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoDigitalResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoDigitalService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar um produtoDigital")
    @ApiResponse(responseCode = "200")
    @PutMapping(path = "/{id}", consumes = { "application/json" })
    public ResponseEntity<ProdutoDigitalResponseDTO> alteraProdutoDigital(
            @RequestBody @Valid ProdutoDigitalRequestDTO produtoDigitalRequestDTO, @PathVariable Long id) {
        return ResponseEntity.ok(produtoDigitalService.alterar(produtoDigitalRequestDTO, id));
    }

    @Operation(summary = "Buscar produtosDigitais pelo id do administrador")
    @GetMapping(path = "/administrador/{id}/produtosDigitais")
    public ResponseEntity<Collection<ProdutoDigitalResponseDTO>> buscarPeloIdAdministrador(@PathVariable long id) {
        return ResponseEntity.ok(produtoDigitalService.buscarProdutoDigitalPeloAdministrador(id));
    }
}
