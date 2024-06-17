package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.edu.pe.cibertec.entity.Autor;

public interface AutorService {

	public abstract List<Autor> listadoAutores();
	public abstract Optional<Autor> buscarAutor(int id);
	public abstract Autor registrar(Autor objAutor);
	public abstract void eliminarAutor(int id);
}
