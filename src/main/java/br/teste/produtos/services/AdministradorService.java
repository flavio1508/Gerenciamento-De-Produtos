package br.teste.produtos.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.teste.produtos.dtos.AdministradorRequestDTO;
import br.teste.produtos.dtos.AdministradorResponseDTO;
import br.teste.produtos.mappers.AdministradorMapper;
import br.teste.produtos.models.Administrador;
import br.teste.produtos.repository.AdministradorRepository;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private AdministradorMapper administradorMapper;

    public AdministradorResponseDTO buscarPorId(Long id) {
        return administradorMapper.administradorParaAdministradorResponseDTO(buscarAdministradorPeloId(id));
    }

    private Administrador buscarAdministradorPeloId(Long id) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id);
        if (administradorOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return administradorOptional.get();
    }

    public AdministradorResponseDTO alterarAdministrador(AdministradorRequestDTO administradorRequestDTO, Long id) {
        Administrador administradorParaAlterar = buscarAdministradorPeloId(id);
        administradorParaAlterar.setNome(administradorRequestDTO.getNome());
        administradorParaAlterar.setEmail(administradorRequestDTO.getEmail());
        administradorParaAlterar.setSenha(administradorRequestDTO.getSenha());

        administradorRepository.save(administradorParaAlterar);

        return administradorMapper.administradorParaAdministradorResponseDTO(administradorParaAlterar);
    }

    public AdministradorResponseDTO cadastrar(AdministradorRequestDTO administradorRequestDTO) throws Exception {
        Administrador administrador = administradorMapper
                .administradorRequestparaAdministrador(administradorRequestDTO);
        administradorRepository.save(administrador);
        return administradorMapper.administradorParaAdministradorResponseDTO(administrador);
    }
}
