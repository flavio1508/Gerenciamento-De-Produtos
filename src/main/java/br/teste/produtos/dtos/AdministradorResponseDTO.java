package br.teste.produtos.dtos;

import br.teste.produtos.models.Administrador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdministradorResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public AdministradorResponseDTO(Administrador administrador){
        this.id = administrador.getId();
        this.nome = administrador.getNome();
        this.email = administrador.getEmail();
        this.senha = administrador.getSenha();
    }
}
