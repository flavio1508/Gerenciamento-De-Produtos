package br.teste.produtos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoSimplesRequestDTO {
    private String nome;
    private String descricao;
    private double valor;
    private String dataLimite;
    private int quantidadeDeProduto;
    private Long idDaCrianca;

}
