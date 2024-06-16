package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.edu.pe.cibertec.entity.Autor;

public interface AutorService {

	public List<Autor> ListadoAutores();
	public Optional<Autor> BuscarAutor(int id);
	public int Grabar(Autor objA);
	public void Suprimir(int id);
}
