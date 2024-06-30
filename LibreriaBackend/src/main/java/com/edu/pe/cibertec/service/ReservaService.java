package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.edu.pe.cibertec.entity.Reserva;


public interface ReservaService {

	public abstract Reserva insertaActualizaReserva(Reserva objReserva );
	public abstract List<Reserva> listarReservas();
	public abstract Optional<Reserva> buscarReserva(int id);
	public abstract void eliminarReserva(int id);
}
