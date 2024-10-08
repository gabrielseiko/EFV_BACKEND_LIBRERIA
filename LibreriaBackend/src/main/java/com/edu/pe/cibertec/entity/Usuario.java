package com.edu.pe.cibertec.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Entity
@Table(name= "tbl_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private int idUsuario;
    
    @Column(name = "nombres")
    private String nombres;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "dni")
    private String dni;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "fechaNac")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaNac;
    
    @Column(name = "sexo")
    private String sexo; 
    
    @Column(name = "user")
    private String user;
    
    @Column(name = "contrasenia")
    private String contrasenia;
    
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRecursivo")
    private Usuario idRecursivo;
    
    @JsonIgnoreProperties("usuarios")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tbl_usuario_has_rol",
               joinColumns = @JoinColumn(name = "idUsuario"),
               inverseJoinColumns = @JoinColumn(name = "idRol"))
    private Set<Rol> roles = new HashSet<>();
    
    public String getNombreCompleto() {
		if (nombres != null && apellidos != null) {
			return apellidos.concat(" ").concat(nombres);	
		}else {
			return ""; 
		}
	}
}
