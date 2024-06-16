package com.edu.pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.pe.cibertec.entity.Autor;

public interface IAutorRepository extends JpaRepository<Autor, Integer> {

	
}
