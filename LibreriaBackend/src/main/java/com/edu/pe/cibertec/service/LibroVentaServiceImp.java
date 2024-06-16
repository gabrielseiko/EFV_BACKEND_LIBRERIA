package com.edu.pe.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.pe.cibertec.entity.LibroVenta;
import com.edu.pe.cibertec.repository.LibroVentaRepository;

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

}
