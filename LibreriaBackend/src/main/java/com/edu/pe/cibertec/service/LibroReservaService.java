package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.edu.pe.cibertec.entity.LibroReserva;

public interface LibroReservaService {
	// Para Validaciones
	public abstract List<LibroReserva> listaLibroReservaPorLibroIgual(int idLibro);
	public abstract List<LibroReserva> listaLibroReservaPorLibroIgualActualiza(int idLibro, int idLibroReserva);
	Optional<LibroReserva> validacionLibroReserva(int idLibro);
	Optional<LibroReserva> validacionLibroReservaActualiza(int idLibro, int idLibroReserva);
	
	// Para el crud
	public abstract LibroReserva insertaActualizaLibroReserva(LibroReserva obj);

	public abstract void eliminaLibroReserva(int id);

	public abstract List<LibroReserva> listaLibroReserva();
	
	//Lista por categoria
	public abstract List<LibroReserva> listaLibroReservaPorCategoria(@Param("idCategoria")int idCategoria);
	
	public abstract List<LibroReserva> listaLibroReservaDisponible(int estado);


}
