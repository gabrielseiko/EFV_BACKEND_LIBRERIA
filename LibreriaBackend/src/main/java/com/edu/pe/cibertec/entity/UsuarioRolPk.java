package com.edu.pe.cibertec.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class UsuarioRolPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name = "idRol")
    private int idRol;
}
