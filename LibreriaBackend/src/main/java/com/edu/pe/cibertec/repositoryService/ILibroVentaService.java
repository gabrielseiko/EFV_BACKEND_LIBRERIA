package com.edu.pe.cibertec.repositoryService;

import java.util.List;

import com.edu.pe.cibertec.entity.LibroVenta;

public interface ILibroVentaService {
	// Para Validaciones
	public abstract List<LibroVenta> listaLibroVentaPorLibroIgual(int idLibro);

	// Para el crud
	public abstract LibroVenta insertaActualizaLibroVenta(LibroVenta obj);

	public abstract void eliminaLibroVenta(int id);

	public abstract List<LibroVenta> listaLibroVenta();
}
