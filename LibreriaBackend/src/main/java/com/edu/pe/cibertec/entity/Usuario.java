package com.edu.pe.cibertec.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "tbl_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Integer idUsuario;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "fechaNac")
	private LocalDate fechaNac;
	
	@Column(name = "sexo")
	private String sexo; 
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "contrasenia")
	private String contrasenia;
	
	@ManyToOne
	@Column(name = "rol")
	private Rol rol;
	
	@Column(name = "idRecursivo")
	private Usuario idRecursivo;
	
	
}
