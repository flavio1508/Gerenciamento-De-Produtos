package br.teste.produtos.mappers;

import java.util.Collection;

import br.teste.produtos.dtos.ProdutoDigitalRequestDTO;
import br.teste.produtos.dtos.ProdutoDigitalResponseDTO;
import br.teste.produtos.models.ProdutoDigital;

public interface ProdutoDigitalMapper {
    public ProdutoDigitalResponseDTO produtoDigitalParaProdutoDigitalResponseDTO(ProdutoDigital produtoDigital);
    public ProdutoDigital produtoDigitalRequestparaProdutoDigital(ProdutoDigitalRequestDTO produtoDigitalRequestDTO) throws Exception;
    public Collection<ProdutoDigitalResponseDTO> produtoDigitalParaProdutoDigitalResponsesDtos(Collection<ProdutoDigital> produtoDigital);

}
