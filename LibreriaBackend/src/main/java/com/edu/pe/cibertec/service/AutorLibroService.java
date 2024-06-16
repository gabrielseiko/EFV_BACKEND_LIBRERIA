package com.edu.pe.cibertec.service;

import com.edu.pe.cibertec.entity.AutorLibro;
import com.edu.pe.cibertec.entity.AutorLibroPk;

import java.util.List;
import java.util.Optional;

public interface AutorLibroService {

    List<AutorLibro> ListadoAutorLibros();
    Optional<AutorLibro> BuscarAutorLibro(AutorLibroPk id);
    int Grabar(AutorLibro objAL);
    void Suprimir(AutorLibroPk id);
}
