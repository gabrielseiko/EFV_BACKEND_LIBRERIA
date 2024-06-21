package com.edu.pe.cibertec.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.pe.cibertec.entity.Enlace;
import com.edu.pe.cibertec.entity.Rol;
import com.edu.pe.cibertec.entity.Usuario;
import com.edu.pe.cibertec.repository.UsuarioRepository;

import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog
@Qualifier("usuarioSeguridadServiceImpl")
public class UsuarioSeguridadServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		log.info(">>>loadUserByUsername >>> " + user);
		UserDetails userDetails = null;
		try {
			Usuario objUsuario = usuarioRepository.findByUser(user);
			if (objUsuario != null) {
				log.info("==> Login =========== " + objUsuario);

				List<Rol> lstRol = usuarioRepository.traerRolesDeUsuario(objUsuario.getIdUsuario());
				log.info("==> Roles =========== " + lstRol);
				
				List<Enlace> lstOpciones = usuarioRepository.traerEnlacesDeUsuario(objUsuario.getIdUsuario());
				log.info("==> Opciones =========== " + lstOpciones);

				userDetails = UsuarioPrincipal.build(objUsuario, lstRol, lstOpciones);
			}
		} catch (IndexOutOfBoundsException e) {
			throw new UsernameNotFoundException("Wrong username");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Database Error");
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Unknown Error");
		}
		return userDetails;
	}

}