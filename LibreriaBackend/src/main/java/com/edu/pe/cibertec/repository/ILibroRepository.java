package com.edu.pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.pe.cibertec.entity.Libro;

public interface ILibroRepository extends JpaRepository<Libro, Integer>{

}
