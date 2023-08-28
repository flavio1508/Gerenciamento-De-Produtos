package br.teste.produtos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.teste.produtos.models.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
    List<Administrador> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT a FROM Administrador a WHERE a.email = :email AND a.senha = :senha")
    Optional<Administrador> obterPorEmailESenha(String email, String senha);
}
