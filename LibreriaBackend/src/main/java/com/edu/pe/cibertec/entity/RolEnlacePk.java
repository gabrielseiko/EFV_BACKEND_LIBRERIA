package com.edu.pe.cibertec.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Embeddable
public class RolEnlacePk implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idRol;
	private int idEnlace;
	
}
