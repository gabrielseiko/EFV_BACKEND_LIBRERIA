package com.edu.pe.cibertec.service;

import java.util.List;

import com.edu.pe.cibertec.entity.LibroReserva;

public interface LibroReservaService {
	// Para Validaciones
	public abstract List<LibroReserva> listaLibroReservaPorLibroIgual(int idLibro);

	// Para el crud
	public abstract LibroReserva insertaActualizaLibroReserva(LibroReserva obj);

	public abstract void eliminaLibroReserva(int id);

	public abstract List<LibroReserva> listaLibroReserva();

}
