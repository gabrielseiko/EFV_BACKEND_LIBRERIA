package com.edu.pe.cibertec.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_libroventa")
public class LibroVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLibroVenta")
    private int idLibroVenta;
    
    @Column(name = "precio")
    private double precio;
    
    @Column(name = "stock")
    private int stock;
    
    @Column(name = "estado")
    private int estado;
    
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro")
    private Libro libro;
}
