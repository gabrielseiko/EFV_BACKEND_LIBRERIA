package com.edu.pe.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.pe.cibertec.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
	@Query("select r from Reserva r where r.usuario.idUsuario = :idUsuario")
	public abstract List<Reserva> listaReservasCliente(@Param("idUsuario")int idUsuario);
}
