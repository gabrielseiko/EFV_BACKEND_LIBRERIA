package com.edu.pe.cibertec.entity;

import java.time.LocalDateTime;

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
@Table(name = "tbl_venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVenta")
    private int idVenta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "formaPago")
    private String formaPago;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "estado")
    private int estado;

    @Column(name = "montoIGV")
    private double montoIGV;

    @Column(name = "total")
    private double total;
}
