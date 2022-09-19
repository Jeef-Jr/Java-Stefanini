package com.stefaninifood.food.services;

import com.stefaninifood.food.controller.dto.DadosItemDto;
import com.stefaninifood.food.controller.dto.ItemDto;
import com.stefaninifood.food.controller.form.ItemAtualizacao;
import com.stefaninifood.food.controller.form.ItemForm;
import com.stefaninifood.food.modelo.Item;
import com.stefaninifood.food.repository.EmpresaRepository;
import com.stefaninifood.food.repository.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServices {

    private final ItemRepository itemRepository;

    private final EmpresaRepository empresaRepository;

    public ItemServices(ItemRepository itemRepository, EmpresaRepository empresaRepository) {
        this.itemRepository = itemRepository;
        this.empresaRepository = empresaRepository;
    }

    public ResponseEntity<ItemDto> cadastrar(ItemForm form, UriComponentsBuilder uriBuilder){

        Item item = form.dados(empresaRepository);
        itemRepository.save(item);

        URI uri = uriBuilder.path("/itens/${id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemDto(item));
    }

    public List<ItemDto> listarAll(){
        List<Item> itens = itemRepository.findAll();
        return ItemDto.listagem(itens);
    }

    public ResponseEntity<DadosItemDto> listar(Long id){
        Optional<Item> itens = itemRepository.findById(id);

        if(itens.isPresent()){
            return ResponseEntity.ok(new DadosItemDto(itens.get()));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ItemDto> atualizar(Long id, ItemAtualizacao form){
        Optional<Item> itens = itemRepository.findById(id);

        if(itens.isPresent()){
            Item item = form.atualizar(id, itemRepository);
            return ResponseEntity.ok(new ItemDto(itens.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deletar(Long id){
        Optional<Item> itens = itemRepository.findById(id);

        if(itens.isPresent()){
            itemRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }



}
