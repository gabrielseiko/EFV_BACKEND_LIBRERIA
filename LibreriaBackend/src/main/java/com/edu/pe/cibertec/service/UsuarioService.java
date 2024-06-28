package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.Enlace;
import com.edu.pe.cibertec.entity.Rol;
import com.edu.pe.cibertec.entity.Usuario;

public interface UsuarioService {
	
	public abstract List<Enlace> traerEnlacesDeUsuario(int idUsuario);
	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);
	public abstract Usuario registrar(Usuario objUsuario );
	public abstract List<Usuario> listarUsuarios();
	public abstract Optional<Usuario> buscarUsuario(int id);
	public abstract void eliminarUsuario(int id);
	public abstract Usuario buscaPorLogin(String user);
	public abstract List<Usuario> listarTrabajador(int idUsuario);
	public abstract List<Usuario> findAllTrabajadores();
	public abstract List<Usuario> listarClientes();
}
