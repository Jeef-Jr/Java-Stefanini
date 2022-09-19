package com.stefaninifood.food.controller.dto;

import com.stefaninifood.food.modelo.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDto {

    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private String imagem;

    public ItemDto(Item item){
        this.id = item.getId();
        this.nome = item.getNome();
        this.descricao = item.getDescricao();
        this.preco = item.getPreco();
        this.imagem = item.getImagem();
    }

    public static List<ItemDto> listagem (List<Item> item){
        return item.stream().map(ItemDto::new).collect(Collectors.toList());
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
