package br.teste.produtos.services;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.teste.produtos.dtos.ProdutoDigitalRequestDTO;
import br.teste.produtos.dtos.ProdutoDigitalResponseDTO;
import br.teste.produtos.mappers.ProdutoDigitalMapper;
import br.teste.produtos.models.ProdutoDigital;
import br.teste.produtos.repository.ProdutoDigitalRepository;
import br.teste.produtos.utils.DataConvert;

@Service
public class ProdutoDigitalService {
    @Autowired
    private ProdutoDigitalRepository produtoDigitalRepository;

    @Autowired
    private ProdutoDigitalMapper produtoDigitalMapper;

    public ProdutoDigitalService(ProdutoDigitalRepository produtoDigitalRepository,
            ProdutoDigitalMapper produtoDigitalMapper) {
        this.produtoDigitalRepository = produtoDigitalRepository;
        this.produtoDigitalRepository = produtoDigitalRepository;
    }

    public ProdutoDigitalResponseDTO buscarPorId(Long id) {
        return produtoDigitalMapper.produtoDigitalParaProdutoDigitalResponseDTO(buscarProdutoDigitalPeloId(id));
    }

    private ProdutoDigital buscarProdutoDigitalPeloId(Long id) {
        Optional<ProdutoDigital> produtoDigitalOptional = produtoDigitalRepository.findById(id);
        if (produtoDigitalOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return produtoDigitalOptional.get();
    }

    @Transactional
    public ProdutoDigitalResponseDTO cadastrar(ProdutoDigitalRequestDTO produtoDigitalRequestDTO) throws Exception {
        ProdutoDigital produtoDigital = produtoDigitalMapper
                .produtoDigitalRequestparaProdutoDigital(produtoDigitalRequestDTO);
        produtoDigitalRepository.save(produtoDigital);
        return produtoDigitalMapper.produtoDigitalParaProdutoDigitalResponseDTO(produtoDigital);
    }

    public Collection<ProdutoDigitalResponseDTO> buscarTodas() {
        return produtoDigitalMapper.produtoDigitalParaProdutoDigitalResponsesDtos(
                (Collection<ProdutoDigital>) produtoDigitalRepository.findAll());
    }

    public ProdutoDigitalResponseDTO alterar(ProdutoDigitalRequestDTO produtoDigitalRequestDto, long id) {
        ProdutoDigital produtoDigitalParaAlterar = buscarProdutoDigitalPeloId(id);
        produtoDigitalParaAlterar.setDataLimite(DataConvert.obterData(produtoDigitalRequestDto.getDataLimite()));
        produtoDigitalParaAlterar.setDescricao(produtoDigitalRequestDto.getDescricao());
        produtoDigitalParaAlterar.setNome(produtoDigitalRequestDto.getNome());
        produtoDigitalParaAlterar.setValor(produtoDigitalRequestDto.getValor());
        produtoDigitalParaAlterar.setUrlDownload(produtoDigitalRequestDto.getUrlDownload());

        produtoDigitalRepository.save(produtoDigitalParaAlterar);

        return produtoDigitalMapper.produtoDigitalParaProdutoDigitalResponseDTO(produtoDigitalParaAlterar);
    }

    public Collection<ProdutoDigitalResponseDTO> buscarProdutoDigitalPeloAdministrador(Long id) {
        return produtoDigitalMapper.produtoDigitalParaProdutoDigitalResponsesDtos(
                (Collection<ProdutoDigital>) produtoDigitalRepository.findAllByAdministrador(id));
    }

    public void deletar(Long id) {
        produtoDigitalRepository.deleteById(id);
    }
}
