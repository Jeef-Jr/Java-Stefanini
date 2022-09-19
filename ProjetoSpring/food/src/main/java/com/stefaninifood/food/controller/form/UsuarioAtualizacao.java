package com.stefaninifood.food.controller.form;

import com.stefaninifood.food.modelo.Usuario;
import com.stefaninifood.food.repository.UsuarioRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UsuarioAtualizacao {

    @NotNull
    @NotBlank(message = "O campo é obrigatório")
    private String nome;
    @NotNull
    @NotBlank(message = "O campo é obrigatório")
    private String endereco;
    @NotNull
    @NotBlank(message = "O campo é obrigatório")
    private String email;
    @NotNull
    @NotBlank(message = "O campo é obrigatório")
    private String imagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository){
        Usuario usuario =usuarioRepository.getOne(id);
        usuario.setNome(this.nome);
        usuario.setEndereco(this.endereco);
        usuario.setEmail(this.email);
        usuario.getImagem(this.imagem);

        return usuario;
    }

}
