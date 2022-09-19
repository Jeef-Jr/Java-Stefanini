package com.stefaninifood.food.controller.form;

import com.stefaninifood.food.modelo.Item;
import com.stefaninifood.food.repository.ItemRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemAtualizacao {

    @NotNull
    @NotBlank(message = "O nome do item é obrigatório.")
    private String nome;

    @NotBlank(message = "A descrição do item é obrigatória.")
    private String descricao;

    @NotNull
    private Double preco;

    @NotNull
    @NotBlank(message = "A imagem do item é obrigatório.")
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Item atualizar(Long id, ItemRepository itemRepository){
        Item item = itemRepository.getOne(id);
        item.setNome(this.nome);
        item.setDescricao(this.descricao);
        item.setPreco(this.preco);
        item.setImagem(this.imagem);

        return item;
    }


}
