package br.teste.produtos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.teste.produtos.models.ProdutoDigital;

public interface ProdutoDigitalRepository extends CrudRepository<ProdutoDigital, Long> {
    List<ProdutoDigital> findByNomeContainingIgnoreCase(String nome);

}
