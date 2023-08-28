package br.teste.produtos.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.teste.produtos.dtos.AdministradorResponseDTO;
import br.teste.produtos.mappers.AdministradorMapper;
import br.teste.produtos.models.Administrador;
import br.teste.produtos.repository.AdministradorRepository;

@Service
public class AuthService {
    @Autowired
    AdministradorRepository administradorRepository;

    @Autowired
    AdministradorMapper administradorMapper;

    public AdministradorResponseDTO loginAdministrador(String email, String senha) {
        return administradorMapper.administradorParaAdministradorResponseDTO(buscarPeloEmailESenha(email, senha));
    }

    private Administrador buscarPeloEmailESenha(String email, String senha) {
        Administrador administradoroObtido = administradorRepository.obterPorEmailESenha(email, senha).get();
        Optional<Administrador> administradorRetornado = administradorRepository.findById(administradoroObtido.getId());
        if (administradorRetornado.isEmpty()) {
            throw new NoSuchElementException("Usuário Responsável não Encontrado");
        }
        return administradorRetornado.get();
    }
}
