package com.stefaninifood.food.controller.form;

import com.stefaninifood.food.modelo.Usuario;
import com.stefaninifood.food.repository.UsuarioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UsuarioForm {

    @NotNull
    @NotBlank(message = "O nome é obrigatório.")
    @Length(min = 3)
    private String nome;

    @NotNull
    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotNull
    @NotBlank(message = "O e-mail é obrigatório")
    private String email;

    @NotNull
    @NotBlank(message = "A imagem é obrigatória")
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


    public Usuario dados(UsuarioRepository usuarioRepository){
        return new Usuario(nome, endereco, email, imagem);
    }

}
