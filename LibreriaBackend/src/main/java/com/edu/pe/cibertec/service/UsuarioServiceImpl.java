package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.Usuario;
import com.edu.pe.cibertec.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private IUsuarioRepository repository;
	
	@Override
	public Usuario registrar(Usuario objUsuario) {
		return repository.save(objUsuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return repository.findAll();
	}

	@Override
	public Optional<Usuario> buscarUsuario(int id) {
		return repository.findById(id);
	}

	@Override
	public void eliminarUsuario(int id) {
		repository.deleteById(id);
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		return repository.findByUser(login);
	}

}
