package com.edu.pe.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.pe.cibertec.entity.LibroVenta;

public interface LibroVentaRepository extends JpaRepository<LibroVenta, Integer>{
	@Query("select l from LibroVenta l where l.libro.idLibro = ?1")
	public abstract List<LibroVenta> listaLibroVentaPorLibroIgual(int idLibro);

}
