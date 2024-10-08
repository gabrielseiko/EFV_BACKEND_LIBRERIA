package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.Libro;
import com.edu.pe.cibertec.repository.LibroRepository;

@Service
public class LibroServiceImp implements LibroService{
	
	@Autowired
	private LibroRepository repository;
	
	@Override
	public Libro insertaActualizaLibro(Libro obj) {
		return repository.save(obj);
	}
	
	@Override
	public List<Libro> listaLibro() {
		return repository.findAll();
	}

	@Override
	public List<Libro> listaLibroPorTituloIgual(String titulo) {
		return repository.listaLibroPorTituloIgual(titulo);
	}

	@Override
	public List<Libro> listaLibroPorTituloLike(String titulo) {
		return repository.listaLibroPorTituloLike(titulo);
	}

	@Override
	public void eliminaLibro(int id) {
		repository.deleteById(id);		
	}

	@Override
	public List<Libro> listaLibrosPorCategoria(int idCategoria) {
		return repository.listaLibrosPorCategoria(idCategoria);
	}

	@Override
	public Optional<Libro> buscaLibro(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Libro> listaLibroPorTituloIgualActualiza(String titulo, int idLibro) {
		return repository.listaLibroPorTituloIgualActualiza(titulo, idLibro);
	}

}
