package com.edu.pe.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.pe.cibertec.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

	@Query("SELECT a FROM Autor a WHERE a.nombreCompleto LIKE ?1")
	public abstract List<Autor> listaAutorNombreLike(String nombreCompleto);
	
}
