package br.teste.produtos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.teste.produtos.models.ProdutoSimples;

public interface ProdutoSimplesRepository extends CrudRepository<ProdutoSimples, Long> {
        List<ProdutoSimples> findByNomeContainingIgnoreCase(String nome);

}
