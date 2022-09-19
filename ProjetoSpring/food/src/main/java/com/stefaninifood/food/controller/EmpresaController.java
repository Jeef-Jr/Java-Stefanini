package com.stefaninifood.food.controller;

import com.stefaninifood.food.controller.dto.DadosEmpresaDto;
import com.stefaninifood.food.controller.dto.EmpresaDto;
import com.stefaninifood.food.controller.form.EmpresaForm;
import com.stefaninifood.food.repository.EmpresaRepository;
import com.stefaninifood.food.repository.UsuarioRepository;
import com.stefaninifood.food.services.EmpresaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaServices empresaServices;

    @PostMapping
    @Transactional
    public ResponseEntity<EmpresaDto> cadastrar(@RequestBody @Valid EmpresaForm form, UriComponentsBuilder uriBuilder){
       return empresaServices.cadastrar(form, uriBuilder);
    }

    @GetMapping
    public List<EmpresaDto> listagem(){
        return empresaServices.listarAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosEmpresaDto> listar(@PathVariable Long id){
        return empresaServices.listar(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        return empresaServices.deletar(id);
    }

}
