package br.teste.produtos.services;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.teste.produtos.dtos.ProdutoDigitalRequestDTO;
import br.teste.produtos.dtos.ProdutoDigitalResponseDTO;
import br.teste.produtos.dtos.ProdutoSimplesRequestDTO;
import br.teste.produtos.dtos.ProdutoSimplesResponseDTO;
import br.teste.produtos.mappers.ProdutoDigitalMapper;
import br.teste.produtos.mappers.ProdutoSimplesMapper;
import br.teste.produtos.models.ProdutoDigital;
import br.teste.produtos.models.ProdutoSimples;
import br.teste.produtos.repository.ProdutoDigitalRepository;
import br.teste.produtos.repository.ProdutoSimplesRepository;
import br.teste.produtos.utils.DataConvert;

@Service
public class ProdutoSimplesService {
    @Autowired
    private ProdutoSimplesRepository produtoSimplesRepository;

    @Autowired
    private ProdutoSimplesMapper produtoSimplesMapper;

    public ProdutoSimplesService(ProdutoSimplesRepository produtoSimplesRepository,
            ProdutoSimplesMapper produtoSimplesMapper) {
        this.produtoSimplesRepository = produtoSimplesRepository;
        this.produtoSimplesRepository = produtoSimplesRepository;
    }

    public ProdutoSimplesResponseDTO buscarPorId(Long id) {
        return produtoSimplesMapper.produtoSimplesParaProdutoSimplesResponseDTO(buscarProdutoSimplesPeloId(id));
    }

    private ProdutoSimples buscarProdutoSimplesPeloId(Long id) {
        Optional<ProdutoSimples> produtoSimplesOptional = produtoSimplesRepository.findById(id);
        if (produtoSimplesOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return produtoSimplesOptional.get();
    }

    @Transactional
    public ProdutoSimplesResponseDTO cadastrar(ProdutoSimplesRequestDTO produtoSimplesRequestDTO) throws Exception {
        ProdutoSimples produtoSimples = produtoSimplesMapper
                .produtoSimplesRequestparaProdutoSimples(produtoSimplesRequestDTO);
        produtoSimplesRepository.save(produtoSimples);
        return produtoSimplesMapper.produtoSimplesParaProdutoSimplesResponseDTO(produtoSimples);
    }

    public Collection<ProdutoSimplesResponseDTO> buscarTodas() {
        return produtoSimplesMapper.produtoSimplesParaProdutoSimplesResponsesDtos(
                (Collection<ProdutoSimples>) produtoSimplesRepository.findAll());
    }

    public ProdutoSimplesResponseDTO alterar(ProdutoSimplesRequestDTO produtoSimplesRequestDto, long id) {
        ProdutoSimples produtoSimplesParaAlterar = buscarProdutoSimplesPeloId(id);
        produtoSimplesParaAlterar.setDataLimite(DataConvert.obterData(produtoSimplesRequestDto.getDataLimite()));
        produtoSimplesParaAlterar.setDescricao(produtoSimplesRequestDto.getDescricao());
        produtoSimplesParaAlterar.setNome(produtoSimplesRequestDto.getNome());
        produtoSimplesParaAlterar.setValor(produtoSimplesRequestDto.getValor());
        produtoSimplesParaAlterar.setQuantidadeDeProduto(produtoSimplesRequestDto.getQuantidadeDeProduto());

        produtoSimplesRepository.save(produtoSimplesParaAlterar);

        return produtoSimplesMapper.produtoSimplesParaProdutoSimplesResponseDTO(produtoSimplesParaAlterar);
    }

    public Collection<ProdutoSimplesResponseDTO> buscarProdutoSimplesPeloAdministrador(Long id) {
        return produtoSimplesMapper.produtoSimplesParaProdutoSimplesResponsesDtos(
                (Collection<ProdutoSimples>) produtoSimplesRepository.findAllByAdministrador(id));
    }

    public void deletar(Long id) {
        produtoSimplesRepository.deleteById(id);
    }
}
