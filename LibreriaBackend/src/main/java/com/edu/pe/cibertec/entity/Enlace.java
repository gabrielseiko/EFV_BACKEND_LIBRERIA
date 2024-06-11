package com.edu.pe.cibertec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_enlace")
public class Enlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnlace")
    private Integer idEnlace;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ruta")
    private String ruta;

    @OneToMany(mappedBy = "enlace")
    private List<RolEnlace> listaRolEnlace;
}
