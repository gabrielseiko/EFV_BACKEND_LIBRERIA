package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.edu.pe.cibertec.entity.LibroVenta;

public interface LibroVentaService {
	// Para Validaciones
	public abstract List<LibroVenta> listaLibroVentaPorLibroIgual(int idLibro);
	public abstract List<LibroVenta> listaLibroVentaPorLibroIgualActualiza(int idLibro, int idLibroVenta);
	Optional<LibroVenta> validacionLibroVenta(int idLibro);
	Optional<LibroVenta> validacionLibroVentaActualiza(int idLibro, int idLibroVenta);

	// Para el crud
	public abstract LibroVenta insertaActualizaLibroVenta(LibroVenta obj);

	public abstract void eliminaLibroVenta(int id);

	public abstract List<LibroVenta> listaLibroVenta();
	
	//Lista por categoria
	public abstract List<LibroVenta> listaLibroVentaPorCategoria(int idCategoria);
	
	public abstract List<LibroVenta> listaLibroVentaDisponible(int estado);
}
