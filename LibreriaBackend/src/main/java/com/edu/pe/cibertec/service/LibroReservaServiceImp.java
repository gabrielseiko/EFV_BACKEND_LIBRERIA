package com.edu.pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.pe.cibertec.entity.LibroReserva;
import com.edu.pe.cibertec.repository.ILibroReservaRepository;
import com.edu.pe.cibertec.repositoryService.ILibroReservaService;

public class LibroReservaServiceImp implements ILibroReservaService {
	
	@Autowired
	private ILibroReservaRepository repository;

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
