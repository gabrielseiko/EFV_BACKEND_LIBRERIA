package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.edu.pe.cibertec.entity.Categoria;

public interface CategoriaService {

	// Para Validaciones
	public abstract List<Categoria> listaCategoriaPorDescripcionIgual(String descripcion);
	public abstract List<Categoria> listaCategoriaPorDescripcionIgualActualiza(String descripcion, int idCategoria);

	// Para el crud
	public abstract Categoria insertaActualizaCategoria(Categoria obj);

	public abstract List<Categoria> listaCategoriaPorDescripcionLike(String descripcion);

	public abstract void eliminaCategoria(int id);

	public abstract List<Categoria> listaCategoria();

	public abstract Optional<Categoria> buscarCategoria(int id);

}
