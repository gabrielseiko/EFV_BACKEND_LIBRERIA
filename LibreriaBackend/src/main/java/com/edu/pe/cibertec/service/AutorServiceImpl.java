package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.Autor;
import com.edu.pe.cibertec.repository.IAutorRepository;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private IAutorRepository data;
	
	@Override
	public List<Autor> ListadoAutores() {
		return (List<Autor>) data.findAll();
	}

	@Override
	public Optional<Autor> BuscarAutor(int id) {
		return data.findById(id);
	}

	@Override
	public int Grabar(Autor objA) {
		int rpta = 0;
		Autor a = data.save(objA);
		if (!a.equals(null))
			rpta = 1;
		return rpta;
	}

	@Override
	public void Suprimir(int id) {
		data.deleteById(id);
	}

}
