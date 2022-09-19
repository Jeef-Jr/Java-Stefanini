package com.stefaninifood.food.controller.form;

import com.stefaninifood.food.modelo.Empresa;
import com.stefaninifood.food.modelo.Item;
import com.stefaninifood.food.repository.EmpresaRepository;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ItemForm {
    @NotNull
    @NotBlank(message = "O nome do item é obrigatório.")
    private String nome;

    @NotBlank(message = "A descrição do item é obrigatória.")
    private String descricao;

    @NotNull
    private Double preco;

    @NotNull
    private Long idEmpresa;

    @NotNull
    @NotBlank(message = "A imagem do item é obrigatória")
    private String imagem;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Item dados(EmpresaRepository empresaRepository){
        Empresa empresa = empresaRepository.findById(idEmpresa).get();
        return new Item(nome, descricao, preco, imagem, empresa);
    }


}
