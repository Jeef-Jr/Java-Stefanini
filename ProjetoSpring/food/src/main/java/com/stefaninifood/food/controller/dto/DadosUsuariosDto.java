package com.stefaninifood.food.controller.dto;

import com.stefaninifood.food.modelo.Usuario;

import java.time.LocalDateTime;

public class DadosUsuariosDto {

    private Long id;

    private String nome;

    private String endereco;

    private String email;

    private LocalDateTime dataCriacao;

    private String imagem;

    public DadosUsuariosDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.endereco = usuario.getEndereco();
        this.email = usuario.getEmail();
        this.dataCriacao = usuario.getDataCriacao();
        this.imagem = usuario.getImagem(this.imagem);

    }

    public String getImagem() {
        return imagem;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
