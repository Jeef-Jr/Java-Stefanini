package com.stefaninifood.food.controller.form;

import com.stefaninifood.food.modelo.Empresa;
import com.stefaninifood.food.modelo.Item;
import com.stefaninifood.food.modelo.Usuario;
import com.stefaninifood.food.repository.EmpresaRepository;
import com.stefaninifood.food.repository.UsuarioRepository;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class EmpresaForm {

    @NotNull
    @NotBlank(message = "Campo nome obrigatório.")
    private String nome;

    @NotNull
    @NotBlank(message = "Campo nome obrigatório.")
    private String cnpj;

    @NotNull
    private Long owner;

    private List<Item> itens;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }


    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Empresa dados(UsuarioRepository usuarioRepository){

        Usuario owners = usuarioRepository.findById(owner).get();
        return new Empresa(nome, cnpj, owners);
    }


}
