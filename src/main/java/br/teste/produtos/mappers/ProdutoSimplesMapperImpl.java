package br.teste.produtos.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.teste.produtos.dtos.ProdutoSimplesRequestDTO;
import br.teste.produtos.dtos.ProdutoSimplesResponseDTO;
import br.teste.produtos.models.Administrador;
import br.teste.produtos.models.ProdutoSimples;
import br.teste.produtos.repository.AdministradorRepository;
import br.teste.produtos.utils.DataConvert;

@Component
public class ProdutoSimplesMapperImpl implements ProdutoSimplesMapper {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public ProdutoSimplesResponseDTO produtoSimplesParaProdutoSimplesResponseDTO(ProdutoSimples produtoSimples) {
        return new ProdutoSimplesResponseDTO(produtoSimples.getId(),
                produtoSimples.getNome(),
                produtoSimples.getDescricao(),
                produtoSimples.getValor(),
                produtoSimples.getDataLimite(),
                produtoSimples.getQuantidadeDeProduto(),
                produtoSimples.getAdministrador().getId());
    }

    @Override
    public ProdutoSimples produtoSimplesRequestparaProdutoSimples(ProdutoSimplesRequestDTO produtoSimplesRequestDTO)
            throws Exception {
        Administrador administrador = verificaSeObjetoEhNulo(produtoSimplesRequestDTO);

        return new ProdutoSimples(
                produtoSimplesRequestDTO.getNome(),
                produtoSimplesRequestDTO.getDescricao(),
                produtoSimplesRequestDTO.getValor(),
                DataConvert.obterData(produtoSimplesRequestDTO.getDataLimite()),
                produtoSimplesRequestDTO.getQuantidadeDeProduto(),
                administrador);
    }

    private Administrador verificaSeObjetoEhNulo(ProdutoSimplesRequestDTO produtoSimplesRequestDTO) {
        Optional<Administrador> administradorOptional = administradorRepository
                .findById(produtoSimplesRequestDTO.getIdDoAdministrador());
        if (administradorOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        Administrador administrador = administradorOptional.get();
        return administrador;
    }

    @Override
    public Collection<ProdutoSimplesResponseDTO> produtoSimplesParaProdutoSimplesResponsesDtos(
            Collection<ProdutoSimples> produtosSimples) {
        Collection<ProdutoSimplesResponseDTO> produtoSimplesResponseDtos = new ArrayList<>();

        for (ProdutoSimples produtoSimples : produtosSimples) {
            produtoSimplesResponseDtos.add(produtoSimplesParaProdutoSimplesResponseDTO(produtoSimples));
        }
        return produtoSimplesResponseDtos;
    }
}
