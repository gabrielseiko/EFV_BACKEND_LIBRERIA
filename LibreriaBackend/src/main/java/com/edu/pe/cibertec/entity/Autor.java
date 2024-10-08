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
@Table(name = "tbl_autor")
public class Autor {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "idAutor")
	 private int idAutor; 
	    
	 @Column(name = "nombreCompleto")
	 private String nombreCompleto;

	 @JsonIgnore
	 @OneToMany(mappedBy = "autor")
	 private List<AutorLibro> listaAutorLibro;

}
