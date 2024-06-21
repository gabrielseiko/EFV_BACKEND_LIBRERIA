package com.edu.pe.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.Enlace;
import com.edu.pe.cibertec.entity.Rol;
import com.edu.pe.cibertec.entity.Usuario;
import com.edu.pe.cibertec.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Usuario registrar(Usuario objUsuario) {
        // Cifrar la contraseña antes de guardar
        String encodedPassword = passwordEncoder.encode(objUsuario.getContrasenia());
        objUsuario.setContrasenia(encodedPassword);
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

    public Usuario buscaPorLogin(String user) {
        return repository.findByUser(user);
    }

	@Override
	public List<Enlace> traerEnlacesDeUsuario(int idUsuario) {
		return repository.traerEnlacesDeUsuario(idUsuario);
	}

	@Override
	public List<Rol> traerRolesDeUsuario(int idUsuario) {
		return repository.traerRolesDeUsuario(idUsuario);
	}

}
