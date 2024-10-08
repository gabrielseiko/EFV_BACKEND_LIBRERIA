package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.Categoria;
import com.edu.pe.cibertec.repository.CategoriaRepository;

@Service
public class CategoriaServiceImp implements CategoriaService{

	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public Categoria insertaActualizaCategoria(Categoria obj) {
		return repository.save(obj);
	}
	
	@Override
	public List<Categoria> listaCategoria() {
		return repository.findAll();
	}
	
	@Override
	public List<Categoria> listaCategoriaPorDescripcionIgual(String descripcion) {
		return repository.listaCategoriaPorDescripcionIgual(descripcion);
	}

	@Override
	public List<Categoria> listaCategoriaPorDescripcionLike(String descripcion) {
		return repository.listaCategoriaPorDescripcionLike(descripcion);
	}

	@Override
	public void eliminaCategoria(int id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Categoria> buscarCategoria(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Categoria> listaCategoriaPorDescripcionIgualActualiza(String descripcion, int idCategoria) {
		return repository.listaCategoriaPorDescripcionIgualActualiza(descripcion, idCategoria);
	}
	
}
