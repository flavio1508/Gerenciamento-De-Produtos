package br.teste.produtos.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDigital extends Produto  {
    @Column(nullable = false)
    private String urlDownload;

    public ProdutoDigital(String nome, String descricao, double valor, LocalDate dataLimite, String urlDownload)throws Exception{
        super(nome, descricao, valor, dataLimite);
        this.urlDownload = urlDownload;
    }


    
}
