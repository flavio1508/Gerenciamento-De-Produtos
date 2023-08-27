package br.teste.produtos.mappers;

import java.util.Collection;

import br.teste.produtos.dtos.AdministradorRequestDTO;
import br.teste.produtos.dtos.AdministradorResponseDTO;
import br.teste.produtos.models.Administrador;

public interface AdministradorMapper {
    public AdministradorResponseDTO administradorParaAdministradorResponseDTO(Administrador administrador);
    public Administrador administradorRequestparaAdministrador(AdministradorRequestDTO administradorRequestDTO) throws Exception;
    public Collection<AdministradorResponseDTO> administradorParaAdministradorResponsesDtos(Collection<Administrador> administrador);

}
