package com.edu.pe.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.pe.cibertec.entity.LibroReserva;

public interface LibroReservaRepository extends JpaRepository<LibroReserva, Integer>{
	@Query("select l from tbl_libroreserva l where l.idLibro = ?1")
	public abstract List<LibroReserva> listaLibroReservaPorLibroIgual(int idLibro);

}