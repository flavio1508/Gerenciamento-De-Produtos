package br.teste.produtos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDigitalRequestDTO {
    private String nome;
    private String descricao;
    private double valor;
    private String dataLimite;
    private String urlDownload;
    private long idDoAdministrador;

}
