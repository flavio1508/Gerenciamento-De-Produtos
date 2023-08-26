package br.teste.produtos.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@AllArgsConstructor
public class LoginDTO {
    private String email;
    private String senha;
}
