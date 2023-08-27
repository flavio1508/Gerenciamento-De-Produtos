package br.teste.produtos.services;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

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

    public ProdutoDigitalService (ProdutoDigitalRepository produtoDigitalRepository, ProdutoDigitalMapper produtoDigitalMapper){
        this.produtoDigitalRepository = produtoDigitalRepository;
        this.produtoDigitalRepository = produtoDigitalRepository;
    }

    public ProdutoDigitalResponseDTO buscarPorId(Long id){
        return produtoDigitalMapper.produtoDigitalParaProdutoDigitalResponseDTO(buscarProdutoDigitalPeloId(id));
    }

    private ProdutoDigital buscarProdutoDigitalPeloId(Long id) {
        Optional<ProdutoDigital> produtoDigitalOptional = produtoDigitalRepository.findById(id);
        if(produtoDigitalOptional.isEmpty()){
            throw new NoSuchElementException();
        }
        return produtoDigitalOptional.get();
    }

    @Transactional
    public TarefaResponseDTO cadastrar(TarefaRequestDTO  tarefaRequestDTO) {
        Tarefa tarefa = tarefaMapper.tarefaRequestparaTarefa(tarefaRequestDTO);
        tarefaRepository.save(tarefa);
        return tarefaMapper.tarefaParaTarefaResponseDTO(tarefa);   
    }

    public Collection<TarefaResponseDTO> buscarTodas() {        
        return tarefaMapper.tarefasParaTarefasResponsesDtos((Collection<Tarefa>) tarefaRepository.findAll());
    }

    public TarefaResponseDTO alterar(TarefaRequestDTO tarefaRequestDto, long id) {
        Tarefa tarefaParaAlterar = buscarTarefaPeloId(id);
        tarefaParaAlterar.setDataLimite(DataConvert.obterData(tarefaRequestDto.getDataLimite()));
        tarefaParaAlterar.setHoraLimite(DataConvert.obterHoraLimiteCompleta(tarefaRequestDto.getDataLimite(), tarefaRequestDto.getHoraLimite()));
        tarefaParaAlterar.setNome(tarefaRequestDto.getNome());
        tarefaParaAlterar.setValor(tarefaRequestDto.getValor());

        tarefaRepository.save(tarefaParaAlterar);

        return tarefaMapper.tarefaParaTarefaResponseDTO(tarefaParaAlterar); 
    }    

    public Collection<TarefaResponseDTO> buscarTarefasPelaCrianca(Long id){
        return tarefaMapper.tarefasParaTarefasResponsesDtos((Collection<Tarefa>) tarefaRepository.findAllByCrianca(id));
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }
}
