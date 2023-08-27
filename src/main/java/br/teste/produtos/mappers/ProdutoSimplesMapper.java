package br.teste.produtos.mappers;

import java.util.Collection;

import br.teste.produtos.dtos.ProdutoSimplesRequestDTO;
import br.teste.produtos.dtos.ProdutoSimplesResponseDTO;
import br.teste.produtos.models.ProdutoSimples;

public interface ProdutoSimplesMapper {
    public ProdutoSimplesResponseDTO produtoSimplesParaProdutoSimplesResponseDTO(ProdutoSimples produtoSimples);
    public ProdutoSimples produtoSimplesRequestparaProdutoSimples(ProdutoSimplesRequestDTO produtoSimplesRequestDTO) throws Exception;
    public Collection<ProdutoSimplesResponseDTO> produtoSimplesParaProdutoSimplesResponsesDtos(Collection<ProdutoSimples> produtoSimples);

}
