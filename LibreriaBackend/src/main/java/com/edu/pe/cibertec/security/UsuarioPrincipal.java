package com.edu.pe.cibertec.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.edu.pe.cibertec.entity.Enlace;
import com.edu.pe.cibertec.entity.Rol;
import com.edu.pe.cibertec.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;

@Getter
@Setter
@AllArgsConstructor
@CommonsLog
@ToString
public class UsuarioPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String login;
	private String password;
	private String nombreUsuario;
	private static String nombreCompleto;
	private Collection<? extends GrantedAuthority> authorities;
	private List<Enlace> opciones;
	
	public static UsuarioPrincipal build(Usuario usuario, List<Rol> roles, List<Enlace> opciones) {
		log.info(">>>UsuarioPrincipal >> " + usuario);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Rol x : roles) {
			authorities.add(new SimpleGrantedAuthority(x.getDescripcion()));
		}
		nombreCompleto = usuario.getNombreCompleto();
		return new UsuarioPrincipal(usuario.getIdUsuario(), usuario.getUser(), usuario.getContrasenia(), usuario.getNombreCompleto(), authorities, opciones);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

}
