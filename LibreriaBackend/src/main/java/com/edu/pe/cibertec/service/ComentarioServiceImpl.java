package com.edu.pe.cibertec.service;

import com.edu.pe.cibertec.entity.Comentario;
import com.edu.pe.cibertec.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImpl implements ComentarioService{

    @Autowired
    private ComentarioRepository repository;

	@Override
	public List<Comentario> listarComentarios() {
		return repository.findAll();
	}

	@Override
	public Optional<Comentario> buscarComentario(int id) {
		return repository.findById(id);
	}

	@Override
	public Comentario registrar(Comentario objComentario) {
		return  repository.save(objComentario);
	}

	@Override
	public void eliminarComentario(int id) {
		repository.deleteById(id);
	}

   
}
