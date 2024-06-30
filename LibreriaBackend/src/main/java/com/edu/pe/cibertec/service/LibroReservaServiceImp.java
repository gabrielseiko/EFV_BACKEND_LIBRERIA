package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.LibroReserva;
import com.edu.pe.cibertec.repository.LibroReservaRepository;

@Service
public class LibroReservaServiceImp implements LibroReservaService {
	
	@Autowired
	private LibroReservaRepository repository;

	@Override
	public LibroReserva insertaActualizaLibroReserva(LibroReserva obj) {
		return repository.save(obj);
	}
	
	@Override
	public List<LibroReserva> listaLibroReserva() {
		return repository.findAll();
	}
	@Override
	public List<LibroReserva> listaLibroReservaPorLibroIgual(int idLibro) {
		return repository.listaLibroReservaPorLibroIgual(idLibro);
	}

	@Override
	public void eliminaLibroReserva(int id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<LibroReserva> validacionLibroReserva(int idLibro) {
		return repository.validacionLibroReserva(idLibro);
	}

	@Override
	public List<LibroReserva> listaLibroReservaPorLibroIgualActualiza(int idLibro, int idLibroReserva) {
		return repository.listaLibroReservaPorLibroIgualActualiza(idLibro, idLibroReserva);
	}

	@Override
	public Optional<LibroReserva> validacionLibroReservaActualiza(int idLibro, int idLibroReserva) {
		return repository.validacionLibroReservaActualiza(idLibro, idLibroReserva);
	}

	@Override
	public List<LibroReserva> listaLibroReservaPorCategoria(int idCategoria) {
		return repository.listaLibroReservaPorCategoria(idCategoria);
	}

}
