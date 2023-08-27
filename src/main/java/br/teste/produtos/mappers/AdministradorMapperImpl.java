package br.teste.produtos.mappers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import br.teste.produtos.dtos.AdministradorRequestDTO;
import br.teste.produtos.dtos.AdministradorResponseDTO;
import br.teste.produtos.models.Administrador;

@Component
public class AdministradorMapperImpl implements AdministradorMapper {
    @Override
    public AdministradorResponseDTO administradorParaAdministradorResponseDTO(Administrador administrador) {
        return new AdministradorResponseDTO(administrador.getId(),
                administrador.getNome(),
                administrador.getEmail(),
                administrador.getSenha());
    }

    @Override
    public Administrador administradorRequestparaAdministrador(AdministradorRequestDTO administradorRequestDTO)
            throws Exception {
        return new Administrador(
                administradorRequestDTO.getNome(),
                administradorRequestDTO.getEmail(),
                administradorRequestDTO.getSenha());
    }

    @Override
    public Collection<AdministradorResponseDTO> administradorParaAdministradorResponsesDtos(
            Collection<Administrador> administrador) {
        Collection<AdministradorResponseDTO> administradorResponseDto = new ArrayList<>();

        for (Administrador administrador2 : administrador) {
            administradorResponseDto.add(administradorParaAdministradorResponseDTO(administrador2));
        }
        return administradorResponseDto;
    }

}
