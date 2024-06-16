package com.edu.pe.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.pe.cibertec.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
	@Query("select c from tbl_categoria c where c.descripcion = ?1")
	public abstract List<Categoria> listaCategoriaPorDescripcionIgual(String descripcion);
	
	@Query("select c from tbl_categoria c where c.descripcion like ?1")
	public abstract List<Categoria> listaCategoriaPorDescripcionLike(String descripcion);
}