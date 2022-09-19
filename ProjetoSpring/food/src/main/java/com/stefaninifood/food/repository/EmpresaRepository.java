package com.stefaninifood.food.repository;

import com.stefaninifood.food.modelo.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

     Optional<Empresa> findById(Long idEmpresa);


}
