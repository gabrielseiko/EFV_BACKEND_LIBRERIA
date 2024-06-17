package com.edu.pe.cibertec.controller;

import com.edu.pe.cibertec.entity.Comentario;
import com.edu.pe.cibertec.entity.Usuario;
import com.edu.pe.cibertec.service.ComentarioService;
import com.edu.pe.cibertec.service.ComentarioServiceImpl;
import com.edu.pe.cibertec.util.AppSettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/url/comentario")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
	public ResponseEntity<List<Comentario>> listarComentarios(){
		List<Comentario> salida = comentarioService.listarComentarios();
		return ResponseEntity.ok(salida);
	}

    @GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> buscarComentario(@PathVariable("id") int idComentario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Comentario> optionalComentario = comentarioService.buscarComentario(idComentario);
	        if (optionalComentario.isPresent()) {
	            salida.put("comentario", optionalComentario.get());
	        } else {
	            salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	           }
	   } catch (Exception e) {
	       e.printStackTrace();
	       salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	    }
	   return ResponseEntity.ok(salida);
	 }

    @PostMapping("/registrarComentario")
	@ResponseBody
	public ResponseEntity<?> registrarComentario(@RequestBody Comentario objComentario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			objComentario.setIdComentario(0);
			
			Comentario objSalida = comentarioService.registrar(objComentario);
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
    
    @PutMapping("/actualizarComentario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarComentario(@RequestBody Comentario objComentario) {
		Map<String, Object> salida = new HashMap<>();
		try {

			Comentario objSalida = comentarioService.registrar(objComentario);
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

    @DeleteMapping("/eliminarComentario/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarComentario(@PathVariable("id") int idComentario) {
		Map<String, Object> salida = new HashMap<>();
		try {
			comentarioService.eliminarComentario(idComentario);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
