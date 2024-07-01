package com.edu.pe.cibertec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.pe.cibertec.entity.LibroVenta;

public interface LibroVentaRepository extends JpaRepository<LibroVenta, Integer>{
	@Query("select l from LibroVenta l where l.libro.idLibro = ?1")
	public abstract List<LibroVenta> listaLibroVentaPorLibroIgual(int idLibro);
	
	@Query("select l from LibroVenta l where l.libro.idLibro = ?1 and l.idLibroVenta != ?2 ")
	public abstract List<LibroVenta> listaLibroVentaPorLibroIgualActualiza(int idLibro, int idLibroVenta);
	
	@Query("select l from  LibroVenta l where l.libro.idLibro = :idLibro")
    Optional<LibroVenta> validacionLibroVenta(@Param("idLibro") int idLibro);
	
	@Query("select l from LibroVenta l where l.libro.idLibro = :idLibro and l.idLibroVenta != :idLibroVenta")
	Optional<LibroVenta> validacionLibroVentaActualiza(@Param("idLibro")int idLibro, @Param("idLibroVenta")int idLibroVenta);
	
	@Query("select l from LibroVenta l where l.libro.categoria.idCategoria = :idCategoria and l.estado = 1")
	public abstract List<LibroVenta> listaLibroVentaPorCategoria(@Param("idCategoria")int idCategoria);
	
	@Query("select l from LibroReserva l where l.estado = ?1")
	public abstract List<LibroVenta> listaLibroVentaDisponible(int estado);


}
