package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.LibroVenta;
import com.edu.pe.cibertec.repository.LibroVentaRepository;

@Service
public class LibroVentaServiceImp implements LibroVentaService {
	
	@Autowired
	private LibroVentaRepository repository;
	
	@Override
	public LibroVenta insertaActualizaLibroVenta(LibroVenta obj) {
		return repository.save(obj);
	}
	
	@Override
	public List<LibroVenta> listaLibroVenta() {
		return repository.findAll();
	}

	@Override
	public List<LibroVenta> listaLibroVentaPorLibroIgual(int idLibro) {
		return repository.listaLibroVentaPorLibroIgual(idLibro);
	}

	@Override
	public void eliminaLibroVenta(int id) {
		repository.deleteById(id);		
	}

	@Override
	public Optional<LibroVenta> validacionLibroVenta(int idLibro) {
		return repository.validacionLibroVenta(idLibro);
	}

	@Override
	public List<LibroVenta> listaLibroVentaPorLibroIgualActualiza(int idLibro, int idLibroVenta) {
		return repository.listaLibroVentaPorLibroIgualActualiza(idLibro, idLibroVenta);
	}

	@Override
	public Optional<LibroVenta> validacionLibroVentaActualiza(int idLibro, int idLibroVenta) {
		return repository.validacionLibroVentaActualiza(idLibro, idLibroVenta);
	}

}
