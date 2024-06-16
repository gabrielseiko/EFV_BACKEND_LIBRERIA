package com.edu.pe.cibertec.service;

import com.edu.pe.cibertec.entity.Comentario;
import com.edu.pe.cibertec.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImpl {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> getComentarioById(int id) {
        return comentarioRepository.findById(id);
    }

    public Comentario saveComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public void deleteComentario(int id) {
        comentarioRepository.deleteById(id);
    }
}
