package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.edu.pe.cibertec.entity.LibroReserva;

public interface LibroReservaService {
	// Para Validaciones
	public abstract List<LibroReserva> listaLibroReservaPorLibroIgual(int idLibro);
	
	Optional<LibroReserva> validacionLibroReserva(int idLibro);
	

	// Para el crud
	public abstract LibroReserva insertaActualizaLibroReserva(LibroReserva obj);

	public abstract void eliminaLibroReserva(int id);

	public abstract List<LibroReserva> listaLibroReserva();

}
