package com.edu.pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.pe.cibertec.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
