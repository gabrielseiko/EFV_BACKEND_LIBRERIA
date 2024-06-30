package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.Reserva;
import com.edu.pe.cibertec.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository repository;
	
	@Override
	public Reserva insertaActualizaReserva(Reserva objReserva) {
		return repository.save(objReserva);
	}

	@Override
	public List<Reserva> listarReservas() {
		return repository.findAll();
	}

	@Override
	public Optional<Reserva> buscarReserva(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminarReserva(int id) {
		repository.deleteById(id);
	}

}
