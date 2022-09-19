package com.stefaninifood.food.controller;

import com.stefaninifood.food.controller.dto.DadosItemDto;
import com.stefaninifood.food.controller.dto.ItemDto;
import com.stefaninifood.food.controller.form.ItemAtualizacao;
import com.stefaninifood.food.controller.form.ItemForm;
import com.stefaninifood.food.repository.EmpresaRepository;
import com.stefaninifood.food.repository.ItemRepository;
import com.stefaninifood.food.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ItemServices itemServices;

    @PostMapping
    @Transactional
    public ResponseEntity<ItemDto> cadastrar(@RequestBody @Valid ItemForm form, UriComponentsBuilder uriBuilder){
        return itemServices.cadastrar(form, uriBuilder);
    }

    @GetMapping
    public List<ItemDto> listagem(){
        return itemServices.listarAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosItemDto> listar(@PathVariable Long id){
        return itemServices.listar(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ItemDto> atualizar(@PathVariable Long id, @RequestBody @Valid ItemAtualizacao form){
        return itemServices.atualizar(id, form);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        return itemServices.deletar(id);
    }

}
