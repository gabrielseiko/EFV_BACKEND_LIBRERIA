package com.edu.pe.cibertec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.pe.cibertec.entity.LibroReserva;
import com.edu.pe.cibertec.entity.LibroVenta;

public interface LibroReservaRepository extends JpaRepository<LibroReserva, Integer>{

	@Query("select l from LibroReserva l where l.libro.idLibro = ?1")
	public abstract List<LibroReserva> listaLibroReservaPorLibroIgual(int idLibro);
	
	@Query("select l from LibroReserva l where l.libro.idLibro = ?1 and l.idLibroReserva != ?2")
	public abstract List<LibroReserva> listaLibroReservaPorLibroIgualActualiza(int idLibro, int idLibroReserva);
	
	@Query("select l from  LibroReserva l where l.libro.idLibro = :idLibro")
    Optional<LibroReserva> validacionLibroReserva(@Param("idLibro") int idLibro);
	
	@Query("select l from LibroReserva l where l.libro.idLibro = :idLibro and l.idLibroReserva != :idLibroReserva")
	Optional<LibroReserva> validacionLibroReservaActualiza(@Param("idLibro")int idLibro, @Param("idLibroReserva")int idLibroReserva);
	
	@Query("select l from LibroReserva l where l.libro.categoria.idCategoria = :idCategoria")
	public abstract List<LibroReserva> listaLibroReservaPorCategoria(@Param("idCategoria")int idCategoria);

}
