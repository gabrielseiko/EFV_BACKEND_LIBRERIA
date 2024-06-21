package com.edu.pe.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.pe.cibertec.entity.Usuario;
import com.edu.pe.cibertec.service.UsuarioService;
import com.edu.pe.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/usuario")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario> salida = usuarioService.listarUsuarios();
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> buscarUsuario(@PathVariable("id") int idUsuario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Usuario> optionalUsuario = usuarioService.buscarUsuario(idUsuario);
	        if (optionalUsuario.isPresent()) {
	            salida.put("usuario", optionalUsuario.get());
	        } else {
	            salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	           }
	   } catch (Exception e) {
	       e.printStackTrace();
	       salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	    }
	   return ResponseEntity.ok(salida);
	 }
	
	@PostMapping("/registrarUsuario")
	@ResponseBody
	public ResponseEntity<?> registrarUsuario(@RequestBody Usuario objUsuario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			objUsuario.setIdUsuario(0);
			
			Usuario objSalida = usuarioService.registrar(objUsuario);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizarUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarUsuario(@RequestBody Usuario objUsuario) {
		Map<String, Object> salida = new HashMap<>();
		try {

			Usuario objSalida = usuarioService.registrar(objUsuario);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarUsuario(@PathVariable("id") int idUsuario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			usuarioService.eliminarUsuario(idUsuario);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
