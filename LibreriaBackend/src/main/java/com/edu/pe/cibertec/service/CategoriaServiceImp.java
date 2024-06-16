package com.edu.pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.pe.cibertec.entity.Categoria;
import com.edu.pe.cibertec.repository.CategoriaRepository;

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
	
}
