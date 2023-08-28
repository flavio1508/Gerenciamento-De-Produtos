package br.teste.produtos.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.teste.produtos.models.ProdutoDigital;

public interface ProdutoDigitalRepository extends CrudRepository<ProdutoDigital, Long> {
    List<ProdutoDigital> findByNomeContainingIgnoreCase(String nome);

     @Query("SELECT t FROM ProdutoDigital t JOIN t.administrador c WHERE c.id = :idDoAdministrador")
    Collection <ProdutoDigital> findAllByAdministrador(Long idDoAdministrador);

}
