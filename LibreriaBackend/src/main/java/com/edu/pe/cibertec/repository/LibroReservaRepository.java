package com.edu.pe.cibertec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.pe.cibertec.entity.LibroReserva;

public interface LibroReservaRepository extends JpaRepository<LibroReserva, Integer>{
	@Query("select l from LibroReserva l where l.libro.idLibro = ?1")
	public abstract List<LibroReserva> listaLibroReservaPorLibroIgual(int idLibro);
	
	@Query("select l from  LibroReserva l where l.libro.idLibro = :idLibro")
    Optional<LibroReserva> validacionLibroReserva(@Param("idLibro") int idLibro);

}
