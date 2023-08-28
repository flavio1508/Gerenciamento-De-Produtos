package br.teste.produtos.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.assertj.core.api.Assertions;

import java.util.List;

import br.teste.produtos.dtos.AdministradorRequestDTO;
import br.teste.produtos.dtos.AdministradorResponseDTO;
import br.teste.produtos.models.Administrador;
import br.teste.produtos.repository.AdministradorRepository;
import br.teste.produtos.utils.JsonUtil;

import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class AdministradorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AdministradorRepository administradorRepository;

    @BeforeEach
    @AfterEach
    public void deleteDados() {
        administradorRepository.deleteAll();
    }

    @Test
    public void deve_incluir_um_administrador() throws Exception {
        int quantitadeEsperado = 1;
        
        AdministradorRequestDTO administradorRequestDTO = new AdministradorRequestDTO("Flavio", "flavioaugusto1508@gmail.com", "123456");

        mockMvc.perform(post("/api/v1/administrador")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(administradorRequestDTO)))
                .andExpect(status().isCreated());

        List<Administrador> administradorRetornados = administradorRepository.findByNomeContainingIgnoreCase(administradorRequestDTO.getNome());
        Assertions.assertThat(administradorRetornados.size()).isEqualTo(quantitadeEsperado);
        Assertions.assertThat(administradorRetornados.stream().map(Administrador::getNome).toList())
                .contains(administradorRequestDTO.getNome());

    }

    @Test
    void deve_buscar_um_administrador_pelo_id() throws Exception {
        Administrador administrador = Administrador.builder().nome("Flavio").email("flavio@gmail.com").senha("14578").build();
        administradorRepository.save(administrador);
        
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/administrador/" + administrador.getId())).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);

        String content = mvcResult.getResponse().getContentAsString();
        AdministradorResponseDTO administradorDTO = JsonUtil.mapFromJsonModuleJavaTime(content, AdministradorResponseDTO.class);

        Assertions.assertThat(administrador.getId()).isEqualTo(administradorDTO.getId());
    }

   
   
}
