package com.edu.pe.cibertec.entity;

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
@Table(name = "tbl_libro_reserva")
public class LibroReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLibroReserva")
    private Integer idLibroReserva;
    
    @Column(name = "stock")
    private int stock;
    
    @Column(name = "estado")
    private int estado;
    
    @ManyToOne
    @JoinColumn(name = "idLibro")
    private Libro libro;
}
