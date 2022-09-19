package com.stefaninifood.food.controller.dto;

import com.stefaninifood.food.modelo.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UsuariosDto {

    private Long id;

    private String nome;

    private String endereco;

    private String email;

    private String imagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    public UsuariosDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.endereco = usuario.getEndereco();
        this.email = usuario.getEmail();
        this.imagem = usuario.getImagem(this.imagem);
        this.dataCriacao = usuario.getDataCriacao();
    }

    public static List<UsuariosDto> listagem(List<Usuario> usuarios) {
       return usuarios.stream().map(UsuariosDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getImagem() {
        return imagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
