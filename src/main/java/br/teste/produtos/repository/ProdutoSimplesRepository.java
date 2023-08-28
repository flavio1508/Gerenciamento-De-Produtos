package br.teste.produtos.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.teste.produtos.models.ProdutoSimples;

public interface ProdutoSimplesRepository extends CrudRepository<ProdutoSimples, Long> {
        List<ProdutoSimples> findByNomeContainingIgnoreCase(String nome);

        @Query("SELECT t FROM ProdutoSimples t JOIN t.administrador c WHERE c.id = :idDoAdministrador")
        Collection<ProdutoSimples> findAllByAdministrador(Long idDoAdministrador);
}
