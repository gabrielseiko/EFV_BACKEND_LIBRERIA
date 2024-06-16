package com.edu.pe.cibertec.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_usuario_has_rol")
public class UsuarioHasRol {

    @EmbeddedId
    private UsuarioRolPk id;

    @ManyToOne
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idRol", insertable = false, updatable = false)
    private Rol rol;
}
