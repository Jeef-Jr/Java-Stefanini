package com.stefaninifood.food.controller.dto;

import com.stefaninifood.food.modelo.Empresa;
import com.stefaninifood.food.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DadosEmpresaDto {

    private Long id;
    private Usuario owner;
    private String nome;
    private String cnpj;

    private List<ItemDto> itens;



    public DadosEmpresaDto(Empresa empresa){
        this.id = empresa.getId();
        this.nome = empresa.getNome();
        this.cnpj = empresa.getCnpj();
        this.itens = new ArrayList<>();
        this.itens.addAll(empresa.getItens().stream().map(ItemDto::new).collect(Collectors.toList()));
        this.owner = empresa.getUsuario();
    }

    public Usuario getOwner() {
        return owner;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<ItemDto> getItens() {
        return itens;
    }
}
