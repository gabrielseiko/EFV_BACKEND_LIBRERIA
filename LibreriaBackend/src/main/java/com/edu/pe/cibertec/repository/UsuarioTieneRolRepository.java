package com.edu.pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.pe.cibertec.entity.UsuarioHasRol;
import com.edu.pe.cibertec.entity.UsuarioRolPk;


public interface UsuarioTieneRolRepository extends JpaRepository<UsuarioHasRol, UsuarioRolPk>{

	

	
}
