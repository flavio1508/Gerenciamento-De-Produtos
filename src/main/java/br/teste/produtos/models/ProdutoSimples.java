package br.teste.produtos.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

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
    private int quantidadeDeProduto;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador administrador;

    public ProdutoSimples(String nome, String descricao, double valor, LocalDate dataLimite, int quantidadeDeProduto,
            Administrador administrador)
            throws Exception {
        super(nome, descricao, valor, dataLimite);
        this.quantidadeDeProduto = quantidadeDeProduto;
        this.administrador = administrador;
    }
}
