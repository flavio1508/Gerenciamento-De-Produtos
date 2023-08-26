package br.teste.produtos.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import br.teste.produtos.utils.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Produto extends EntidadeBase {
    
    @Column(nullable = false, length = 200)
    private String nome;

    @Column(length = 500, nullable = true)
    private String descricao;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private LocalDate dataLimite;

    public Produto(String nome, String descricao, double valor, LocalDate dataLimite) throws Exception {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.dataLimite = dataLimite;
    }
}
