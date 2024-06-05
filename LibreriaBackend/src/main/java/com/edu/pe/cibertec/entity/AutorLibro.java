package com.edu.pe.cibertec.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_Autor_Libro")
public class AutorLibro {

	@EmbeddedId
	private AutorLibroPk id;
	
	@ManyToOne
	@JoinColumn(name = "idAutor", insertable = false, updatable = false, referencedColumnName = "idAutor")
	private Autor autor;
	
	//FALTA QUE CREEN LA ENTIDAD LIBRO
	
}
