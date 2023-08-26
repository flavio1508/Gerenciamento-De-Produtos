package br.teste.produtos.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoSimples extends Produto {
    @Column(nullable = false)
    private int quantidadeDoProduto;

    public ProdutoSimples(String nome, String descricao, double valor, LocalDate dataLimite, int quantidadeDoProduto) throws Exception {
        super(nome, descricao, valor, dataLimite);
        this.quantidadeDoProduto = quantidadeDoProduto;
    }
}
