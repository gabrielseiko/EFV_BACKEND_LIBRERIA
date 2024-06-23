package com.edu.pe.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.pe.cibertec.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	@Query("select c from Categoria c where c.descripcion = ?1")
	public abstract List<Categoria> listaCategoriaPorDescripcionIgual(String descripcion);
	
	@Query("select c from Categoria c where c.descripcion like ?1")
	public abstract List<Categoria> listaCategoriaPorDescripcionLike(String descripcion);
	
	@Query("select c from Categoria c where c.descripcion = ?1 and c.idCategoria != ?2 ")
	public abstract List<Categoria> listaCategoriaPorDescripcionIgualActualiza(String descripcion, int idCategoria);
}
