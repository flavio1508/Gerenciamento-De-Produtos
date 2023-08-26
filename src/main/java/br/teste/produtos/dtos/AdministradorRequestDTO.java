package br.teste.produtos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorRequestDTO {
    private String nome;
    private String email;
    private String senha;
}
