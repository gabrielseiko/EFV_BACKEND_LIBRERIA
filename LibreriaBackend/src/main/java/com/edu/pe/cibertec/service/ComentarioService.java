package com.edu.pe.cibertec.service;

import com.edu.pe.cibertec.entity.Comentario;

import java.util.List;
import java.util.Optional;

public interface ComentarioService {

	public abstract List<Comentario> listarComentarios();
	public abstract Optional<Comentario> buscarComentario(int id);
	public abstract Comentario registrar(Comentario objComentario);
	public abstract void eliminarComentario(int id);
}
