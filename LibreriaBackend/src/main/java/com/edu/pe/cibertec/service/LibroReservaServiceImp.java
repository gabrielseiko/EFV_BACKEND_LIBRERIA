package com.edu.pe.cibertec.service;

import java.util.List;

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
	
}
