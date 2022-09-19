package com.stefaninifood.food.controller.dto;

import com.stefaninifood.food.modelo.Empresa;
import com.stefaninifood.food.modelo.Item;
import com.stefaninifood.food.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpresaDto {

    private Long id;
    private Usuario owner;

    private String nome;

    private String cnpj;

    private List<ItemDto> itens;


        public EmpresaDto(Empresa empresa) {
            this.id = empresa.getId();
            this.owner = empresa.getUsuario();
            this.nome = empresa.getNome();
            this.cnpj = empresa.getCnpj();
            this.itens = new ArrayList<>();
            this.itens.addAll(empresa.getItens().stream().map(ItemDto::new).collect(Collectors.toList()));
        }

    public static List<EmpresaDto> listagem(List<Empresa> empresas){
        return empresas.stream().map(EmpresaDto::new).collect(Collectors.toList());
    }


    public Usuario getUsuario() {
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
