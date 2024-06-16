package com.edu.pe.cibertec.service;

import com.edu.pe.cibertec.entity.AutorLibro;
import com.edu.pe.cibertec.entity.AutorLibroPk;
import com.edu.pe.cibertec.repository.AutorLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorLibroServiceImpl {

    @Autowired
    private AutorLibroRepository autorLibroRepository;

    public List<AutorLibro> getAllAutorLibros() {
        return autorLibroRepository.findAll();
    }

    public Optional<AutorLibro> getAutorLibroById(AutorLibroPk id) {
        return autorLibroRepository.findById(id);
    }

    public AutorLibro saveAutorLibro(AutorLibro autorLibro) {
        return autorLibroRepository.save(autorLibro);
    }

    public void deleteAutorLibro(AutorLibroPk id) {
        autorLibroRepository.deleteById(id);
    }
}
