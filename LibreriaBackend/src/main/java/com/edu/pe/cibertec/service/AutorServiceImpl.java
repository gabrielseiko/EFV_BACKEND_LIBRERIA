package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.Autor;
import com.edu.pe.cibertec.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository repository;

	@Override
	public List<Autor> listadoAutores() {
		return repository.findAll();
	}

	@Override
	public Optional<Autor> buscarAutor(int id) {
		return repository.findById(id);
	}

	@Override
	public Autor registrar(Autor objAutor) {
		return repository.save(objAutor);
	}

	@Override
	public void eliminarAutor(int id) {
		repository.deleteById(id);
	}
	

}
