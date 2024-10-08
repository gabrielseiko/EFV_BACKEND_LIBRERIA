package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;


import com.edu.pe.cibertec.entity.Libro;

public interface LibroService {
	//Lista por categoria
	public abstract List<Libro> listaLibrosPorCategoria(int idCategoria);
	
	// Para Validaciones
	public abstract List<Libro> listaLibroPorTituloIgual(String titulo);
	public abstract List<Libro> listaLibroPorTituloIgualActualiza(String titulo, int idLibro);

	// Para el crud
	public abstract Libro insertaActualizaLibro(Libro obj);

	public abstract List<Libro> listaLibroPorTituloLike(String titulo);

	public abstract void eliminaLibro(int id);

	public abstract List<Libro> listaLibro();

	public abstract Optional<Libro> buscaLibro(int id);
}
