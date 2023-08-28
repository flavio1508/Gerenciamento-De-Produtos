package br.teste.produtos.dtos;

import java.time.LocalDate;

import br.teste.produtos.models.ProdutoSimples;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoSimplesResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private double valor;
    private LocalDate dataLimite;
    private int quantidadeDeProduto;
    private Long idDoAdministrador;

    // public ProdutoSimplesResponseDTO(ProdutoSimples produtoSimples){
    //     this.id = produtoSimples.getId();
    //     this.nome = produtoSimples.getNome();
    //     this.descricao = produtoSimples.getDescricao();
    //     this.valor = produtoSimples.getValor();
    //     this.dataLimite = produtoSimples.getDataLimite();
    //     this.quantidadeDeProduto = produtoSimples.getQuantidadeDeProduto();
    //     this.idDoAdministrador = produtoSimples.getAdministrador();
    // }
}
