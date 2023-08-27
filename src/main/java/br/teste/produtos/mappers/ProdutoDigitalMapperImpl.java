package br.teste.produtos.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.teste.produtos.dtos.ProdutoDigitalRequestDTO;
import br.teste.produtos.dtos.ProdutoDigitalResponseDTO;
import br.teste.produtos.models.Administrador;
import br.teste.produtos.models.ProdutoDigital;
import br.teste.produtos.repository.AdministradorRepository;
import br.teste.produtos.utils.DataConvert;

@Component
public class ProdutoDigitalMapperImpl implements ProdutoDigitalMapper {

    @Autowired
    private AdministradorRepository administradorRepository;
    @Override
    public ProdutoDigitalResponseDTO produtoDigitalParaProdutoDigitalResponseDTO(ProdutoDigital produtoDigital) {
        return new ProdutoDigitalResponseDTO(produtoDigital.getId(),
                produtoDigital.getNome(),
                produtoDigital.getDescricao(),
                produtoDigital.getValor(),
                produtoDigital.getDataLimite(),
                produtoDigital.getUrlDownload());
    }

    @Override
    public ProdutoDigital produtoDigitalRequestparaProdutoDigital(ProdutoDigitalRequestDTO produtoDigitalRequestDTO)
            throws Exception {
                Administrador administrador = verificaSeObjetoEhNulo(produtoDigitalRequestDTO);

        return new ProdutoDigital(
                produtoDigitalRequestDTO.getNome(),
                produtoDigitalRequestDTO.getDescricao(),
                produtoDigitalRequestDTO.getValor(),
                DataConvert.obterData(produtoDigitalRequestDTO.getDataLimite()),
                produtoDigitalRequestDTO.getUrlDownload(),
                administrador
                );
    }
      private Administrador verificaSeObjetoEhNulo(ProdutoDigitalRequestDTO produtoDigitalRequestDTO) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(produtoDigitalRequestDTO.getIdDaCrianca());
        if(administradorOptional.isEmpty()){
            throw new NoSuchElementException();
        }
        Administrador administrador = administradorOptional.get();
        return administrador;
    }

    @Override
    public Collection<ProdutoDigitalResponseDTO> produtoDigitalParaProdutoDigitalResponsesDtos(
            Collection<ProdutoDigital> produtosDigitais) {
        Collection<ProdutoDigitalResponseDTO> produtoDigitalResponseDtos = new ArrayList<>();
    
        for (ProdutoDigital produtoDigital : produtosDigitais) {
            produtoDigitalResponseDtos.add(produtoDigitalParaProdutoDigitalResponseDTO(produtoDigital));
        }
        return produtoDigitalResponseDtos;
    }

}
