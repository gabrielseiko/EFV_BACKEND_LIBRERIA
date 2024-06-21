package com.edu.pe.cibertec.controller;

import com.edu.pe.cibertec.entity.AutorLibro;
import com.edu.pe.cibertec.entity.AutorLibroPk;
import com.edu.pe.cibertec.service.AutorLibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/url/autorlibros")
public class AutorLibroController {

    @Autowired
    private AutorLibroServiceImpl autorLibroService;

    @GetMapping
    public List<AutorLibro> getAllAutorLibros() {
        return autorLibroService.getAllAutorLibros();
    }

    @GetMapping("/{idAutor}/{idLibro}")
    public Optional<AutorLibro> getAutorLibroById(@PathVariable int idAutor, @PathVariable int idLibro) {
        AutorLibroPk id = new AutorLibroPk();
        id.setIdAutor(idAutor);
        id.setIdLibro(idLibro);
        return autorLibroService.getAutorLibroById(id);
    }

    @PostMapping
    public AutorLibro saveAutorLibro(@RequestBody AutorLibro autorLibro) {
        return autorLibroService.saveAutorLibro(autorLibro);
    }

    @DeleteMapping("/{idAutor}/{idLibro}")
    public void deleteAutorLibro(@PathVariable int idAutor, @PathVariable int idLibro) {
        AutorLibroPk id = new AutorLibroPk();
        id.setIdAutor(idAutor);
        id.setIdLibro(idLibro);
        autorLibroService.deleteAutorLibro(id);
    }
}
