package com.stefaninifood.food.controller.dto;

import com.stefaninifood.food.modelo.Item;

public class DadosItemDto {

    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private String imagem;
    public DadosItemDto(Item item){
        this.id = item.getId();
        this.nome = item.getNome();
        this.descricao = item.getDescricao();
        this.preco = item.getPreco();
        this.imagem = item.getImagem();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public String getImagem() {
        return imagem;
    }
}
