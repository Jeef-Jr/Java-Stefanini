package com.stefaninifood.food.controller;

import com.stefaninifood.food.controller.dto.DadosUsuariosDto;
import com.stefaninifood.food.controller.dto.UsuariosDto;
import com.stefaninifood.food.controller.form.UsuarioAtualizacao;
import com.stefaninifood.food.controller.form.UsuarioForm;
import com.stefaninifood.food.repository.UsuarioRepository;
import com.stefaninifood.food.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping
    public List<UsuariosDto> lista(){
       return usuarioServices.listarAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosUsuariosDto> detalhar(@PathVariable Long id){
        return usuarioServices.listar(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuariosDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){
        return usuarioServices.cadastrar(form, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuariosDto> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioAtualizacao form ){
       return usuarioServices.atualizar(id, form);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
       return usuarioServices.deletar(id);
    }




}
