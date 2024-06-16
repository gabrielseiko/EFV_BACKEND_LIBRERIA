package com.edu.pe.cibertec.repositoryService;

import java.util.List;

import com.edu.pe.cibertec.entity.Libro;

public interface ILibroService {
	// Para Validaciones
	public abstract List<Libro> listaLibroPorTituloIgual(String titulo);

	// Para el crud
	public abstract Libro insertaActualizaLibro(Libro obj);

	public abstract List<Libro> listaLibroPorTituloLike(String titulo);

	public abstract void eliminaLibro(int id);

	public abstract List<Libro> listaLibro();

}
