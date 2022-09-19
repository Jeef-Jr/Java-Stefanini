package com.stefaninifood.food.services;

import com.stefaninifood.food.controller.dto.DadosUsuariosDto;
import com.stefaninifood.food.controller.dto.UsuariosDto;
import com.stefaninifood.food.controller.form.UsuarioAtualizacao;
import com.stefaninifood.food.controller.form.UsuarioForm;
import com.stefaninifood.food.modelo.Usuario;
import com.stefaninifood.food.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServices(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuariosDto> listarAll(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuariosDto.listagem(usuarios);
    }

    public ResponseEntity<DadosUsuariosDto> listar(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            return ResponseEntity.ok(new DadosUsuariosDto(usuario.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<UsuariosDto> cadastrar(UsuarioForm form, UriComponentsBuilder uriBuilder){

        Usuario usuario = form.dados(usuarioRepository);
        usuarioRepository.save(usuario);

        URI uri= uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuariosDto(usuario));
    }


    public ResponseEntity<UsuariosDto> atualizar(Long id, UsuarioAtualizacao form){
        Optional<Usuario> optional = usuarioRepository.findById(id);

        if(optional.isPresent()){
            Usuario usuario = form.atualizar(id, usuarioRepository);
            return ResponseEntity.ok(new UsuariosDto(usuario));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deletar(Long id){
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if(optional.isPresent()){
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
