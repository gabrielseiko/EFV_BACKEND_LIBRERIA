package com.edu.pe.cibertec.service;

import com.edu.pe.cibertec.entity.Comentario;

import java.util.List;
import java.util.Optional;

public interface ComentarioService {

    List<Comentario> ListadoComentarios();
    Optional<Comentario> BuscarComentario(int id);
    int Grabar(Comentario objC);
    void Suprimir(int id);
}
