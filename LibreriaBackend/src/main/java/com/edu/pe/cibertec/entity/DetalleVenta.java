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
@Table(name = "tbl_detalle_venta")
public class DetalleVenta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalle")
    private Integer idDetalle;
	
	@ManyToOne
    @JoinColumn(name = "idLibroVenta", referencedColumnName = "idLibroVenta")
    private LibroVenta libro;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "precioUnitario")
	private double precioUnitario;
	
	@Column(name = "subTotal")
	private double subTotal;
	
	 @ManyToOne
	 @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
	 private Venta venta;

	
}
