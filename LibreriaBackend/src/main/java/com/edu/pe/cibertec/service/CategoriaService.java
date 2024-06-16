package com.edu.pe.cibertec.service;

import java.util.List;

import com.edu.pe.cibertec.entity.Categoria;

public interface CategoriaService {

	// Para Validaciones
	public abstract List<Categoria> listaCategoriaPorDescripcionIgual(String descripcion);

	// Para el crud
	public abstract Categoria insertaActualizaCategoria(Categoria obj);

	public abstract List<Categoria> listaCategoriaPorDescripcionLike(String descripcion);

	public abstract void eliminaCategoria(int id);

	public abstract List<Categoria> listaCategoria();

}
