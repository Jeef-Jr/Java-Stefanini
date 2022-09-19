package com.stefaninifood.food.services;

import com.stefaninifood.food.controller.dto.DadosEmpresaDto;
import com.stefaninifood.food.controller.dto.EmpresaDto;
import com.stefaninifood.food.controller.form.EmpresaForm;
import com.stefaninifood.food.modelo.Empresa;
import com.stefaninifood.food.repository.EmpresaRepository;
import com.stefaninifood.food.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServices {

    private final EmpresaRepository empresaRepository;

    private final UsuarioRepository usuarioRepository;

    public EmpresaServices(EmpresaRepository empresaRepository, UsuarioRepository usuarioRepository) {
        this.empresaRepository = empresaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    public ResponseEntity<EmpresaDto> cadastrar(EmpresaForm form, UriComponentsBuilder uriBuilder){
        Empresa empresa = form.dados(usuarioRepository);
        empresaRepository.save(empresa);

        URI uri = uriBuilder.path("/empresas/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmpresaDto(empresa));
    }

    public List<EmpresaDto> listarAll(){
        List<Empresa> empresas = empresaRepository.findAll();
        return EmpresaDto.listagem(empresas);
    }

    public ResponseEntity<DadosEmpresaDto> listar(Long id){
        Optional<Empresa> empresa = empresaRepository.findById(id);

        if(empresa.isPresent()){
            return ResponseEntity.ok(new DadosEmpresaDto(empresa.get()));
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?>  deletar(Long id){

        Optional<Empresa> optional = empresaRepository.findById(id);

        if(optional.isPresent()){
            empresaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
