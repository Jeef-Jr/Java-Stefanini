package com.stefaninifood.food.repository;

import com.stefaninifood.food.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long owner);


}
