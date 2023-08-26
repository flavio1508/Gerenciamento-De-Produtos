package br.teste.produtos.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDigital extends Produto {
    @Column(nullable = false)
    private String urlDownload;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador administrador;

    public ProdutoDigital(String nome, String descricao, double valor, LocalDate dataLimite, String urlDownload,
            Administrador administrador) throws Exception {
        super(nome, descricao, valor, dataLimite);
        this.urlDownload = urlDownload;
        this.administrador = administrador;
    }

}
