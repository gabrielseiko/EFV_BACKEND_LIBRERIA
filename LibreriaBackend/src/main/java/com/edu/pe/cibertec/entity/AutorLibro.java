package com.edu.pe.cibertec.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_Autor_Libro")
public class AutorLibro {

	@EmbeddedId
    private AutorLibroPk id;

    @ManyToOne
    @JoinColumn(name = "idAutor", insertable = false, updatable = false, referencedColumnName = "idAutor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "idLibro", insertable = false, updatable = false, referencedColumnName = "idLibro")
    private Libro libro;
}
