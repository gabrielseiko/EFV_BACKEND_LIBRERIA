package com.edu.pe.cibertec.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrestamo")
    private int idPrestamo;

    @ManyToOne
    @JoinColumn(name = "idLibroReserva")
    private LibroReserva libro;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "fechaReserva")
    private LocalDate fechaReserva;

    @Column(name = "fechaDevolucion")
    private LocalDate fechaDevolucion;

    @Column(name = "estado")
    private int estado;
}
