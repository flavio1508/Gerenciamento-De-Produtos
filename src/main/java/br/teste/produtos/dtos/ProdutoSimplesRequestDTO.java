package br.teste.produtos.dtos;

import java.time.LocalDate;
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
    private LocalDate dataLimite;
    private int quantidadeDeProduto;
}
