package com.edu.pe.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.pe.cibertec.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{
	@Query("select l from Libro l where l.titulo = ?1")
	public abstract List<Libro> listaLibroPorTituloIgual(String titulo);
	
	@Query("select l from Libro l where l.titulo like ?1")
	public abstract List<Libro> listaLibroPorTituloLike(String titulo);
	
	@Query("select l from Libro l where l.categoria.idCategoria = :idCategoria")
	public abstract List<Libro> listaLibrosPorCategoria(@Param("idCategoria")int idCategoria);
}
