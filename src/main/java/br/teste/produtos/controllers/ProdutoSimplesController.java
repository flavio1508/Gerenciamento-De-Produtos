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
import br.teste.produtos.dtos.ProdutoSimplesRequestDTO;
import br.teste.produtos.dtos.ProdutoSimplesResponseDTO;
import br.teste.produtos.services.ProdutoDigitalService;
import br.teste.produtos.services.ProdutoSimplesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = {"api/v1/produtosSimples"}, produces ={"application/json"})
public class ProdutoSimplesController {
            private final ProdutoSimplesService produtoSimplesService;
    
    public ProdutoSimplesController(ProdutoSimplesService produtoSimplesService){
        this.produtoSimplesService = produtoSimplesService;
    }

    @Operation(summary = "Cadastrar um novo produtoSimples")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<ProdutoSimplesResponseDTO> cadastrarProdutoSimples(@RequestBody @Valid ProdutoSimplesRequestDTO produtoSimplesRequestDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSimplesService.cadastrar(produtoSimplesRequestDTO));
    }

    @DeleteMapping(path = "/{id}")
    public void remover(@PathVariable Long id) {
        produtoSimplesService.deletar(id);
    }

    @Operation(summary ="Buscar uma lista dos produtosSimples")
    @ApiResponse(responseCode = "200", description = "Lista de produtosSimples cadastrados")
    @GetMapping
    public ResponseEntity<Collection<ProdutoSimplesResponseDTO>> buscarTodos(){
        return ResponseEntity.ok(produtoSimplesService.buscarTodas());
    }

    @Operation(summary = "Buscar um produtoSimples pelo seu id")
    @ApiResponse(responseCode = "200")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoSimplesResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(produtoSimplesService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar um produtoSimples")
    @ApiResponse(responseCode = "200")
    @PutMapping(path="/{id}", consumes = {"application/json"})
    public ResponseEntity<ProdutoSimplesResponseDTO> alteraProdutoSimples(@RequestBody @Valid ProdutoSimplesRequestDTO produtoSimplesRequestDTO, @PathVariable Long id){
        return ResponseEntity.ok(produtoSimplesService.alterar(produtoSimplesRequestDTO, id));
    }

    @Operation(summary = "Buscar produtosSimples pelo id do administrador")
    @GetMapping(path="/administrador/{id}/produtosSimples")
    public ResponseEntity<Collection<ProdutoSimplesResponseDTO>> buscarPeloIdAdministrador(@PathVariable long id){
        return ResponseEntity.ok(produtoSimplesService.buscarProdutoSimplesPeloAdministrador(id));
    }
}
