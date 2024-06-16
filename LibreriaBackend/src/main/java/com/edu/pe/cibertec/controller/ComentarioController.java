package com.edu.pe.cibertec.controller;

import com.edu.pe.cibertec.entity.Comentario;
import com.edu.pe.cibertec.service.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioServiceImpl comentarioService;

    @GetMapping
    public List<Comentario> getAllComentarios() {
        return comentarioService.getAllComentarios();
    }

    @GetMapping("/{id}")
    public Optional<Comentario> getComentarioById(@PathVariable int id) {
        return comentarioService.getComentarioById(id);
    }

    @PostMapping
    public Comentario saveComentario(@RequestBody Comentario comentario) {
        return comentarioService.saveComentario(comentario);
    }

    @DeleteMapping("/{id}")
    public void deleteComentario(@PathVariable int id) {
        comentarioService.deleteComentario(id);
    }
}
