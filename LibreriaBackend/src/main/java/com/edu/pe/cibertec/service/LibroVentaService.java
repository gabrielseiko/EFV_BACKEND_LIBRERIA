package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.edu.pe.cibertec.entity.LibroVenta;

public interface LibroVentaService {
	// Para Validaciones
	public abstract List<LibroVenta> listaLibroVentaPorLibroIgual(int idLibro);
	
	Optional<LibroVenta> validacionLibroVenta(int idLibro);

	// Para el crud
	public abstract LibroVenta insertaActualizaLibroVenta(LibroVenta obj);

	public abstract void eliminaLibroVenta(int id);

	public abstract List<LibroVenta> listaLibroVenta();
}
