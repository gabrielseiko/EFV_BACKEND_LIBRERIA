package com.edu.pe.cibertec.entity;

import java.time.LocalDate;

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
@Table(name = "tbl_comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComentario")
    private Integer idComentario;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idLibro", referencedColumnName = "idLibro")
    private Libro libro;

    @Column(name = "fechaPu")
    private LocalDate fechaPu;
}
