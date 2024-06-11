package com.edu.pe.cibertec.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRol")
	private int idRol;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<Usuario> listaUsuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "rol")
	private List<RolEnlace> listaRolEnlace;
}
