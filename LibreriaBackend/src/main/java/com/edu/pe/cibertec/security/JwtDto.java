package com.edu.pe.cibertec.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.edu.pe.cibertec.entity.Enlace;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String user;
    private String nombreCompleto;
    private int idUsuario;
    private Collection<? extends GrantedAuthority> authorities;
    private List<Enlace> opciones;

    public JwtDto(String token,String login, String nombreCompleto, int idUsuario, Collection<? extends GrantedAuthority> authorities,List<Enlace> lstOpciones) {
        this.token = token;
        this.user = login;
        this.nombreCompleto = nombreCompleto;
        this.authorities = authorities;
        this.idUsuario = idUsuario;
        this.opciones = lstOpciones;
    }

    
}
