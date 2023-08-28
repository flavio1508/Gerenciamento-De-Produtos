package br.teste.produtos.dtos;

import java.time.LocalDate;

import br.teste.produtos.models.ProdutoDigital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDigitalResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private double valor;
    private LocalDate dataLimite;
    private String urlDownload;
    private long idDoAdministrador;

   
}
