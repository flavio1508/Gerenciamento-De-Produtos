package br.teste.produtos.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.teste.produtos.models.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
    List<Administrador> findByNomeContainingIgnoreCase(String nome);
}
