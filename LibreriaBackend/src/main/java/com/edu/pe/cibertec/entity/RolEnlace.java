package com.edu.pe.cibertec.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_rol_enlace")
public class RolEnlace {

	@EmbeddedId
	private RolEnlacePk id;
	
	@ManyToOne
	@JoinColumn(name = "idEnlace", insertable = false, updatable = false, referencedColumnName = "idEnlace")
	private Enlace enlace;
	
	
}
