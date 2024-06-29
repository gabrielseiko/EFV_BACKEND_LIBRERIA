package com.edu.pe.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.pe.cibertec.entity.Autor;
import com.edu.pe.cibertec.service.AutorServiceImpl;
import com.edu.pe.cibertec.util.AppSettings;

import org.springframework.ui.Model;

@RestController
@RequestMapping("/url/autor")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class AutorController {

	@Autowired
	private AutorServiceImpl autorService;

	//LISTADO DE AUTORES
	@GetMapping
	public ResponseEntity<List<Autor>> listarAutores(){
		List<Autor> salida = autorService.listadoAutores();
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> buscarAutor(@PathVariable("id") int idAutor) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Autor> optionalAutor = autorService.buscarAutor(idAutor);
	        if (optionalAutor.isPresent()) {
	            salida.put("Autor", optionalAutor.get());
	        } else {
	            salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	           }
	   } catch (Exception e) {
	       e.printStackTrace();
	       salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	    }
	   return ResponseEntity.ok(salida);
	 }
	
	@PostMapping("/registrarAutor")
	@ResponseBody
	public ResponseEntity<?> registrarAutor(@RequestBody Autor objAutor) {
		Map<String, Object> salida = new HashMap<>();
		try {
			objAutor.setIdAutor(0);
			
			Autor objSalida = autorService.registrar(objAutor);
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
	
	@PutMapping("/actualizarAutor")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaAutor(@RequestBody Autor objAutor) {
		Map<String, Object> salida = new HashMap<>();
		try {

			Autor objSalida = autorService.registrar(objAutor);
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
	
	@DeleteMapping("/eliminarAutor/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarAutor(@PathVariable("id") int idAutor) {
		Map<String, Object> salida = new HashMap<>();
		try {
			autorService.eliminarAutor(idAutor);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	//VALIDACION AUTOR
	@GetMapping("/validaNombreCompleto")
	public String validaNombreCompleto (@RequestParam(name ="nombreCompleto") String nombreCompleto) {
		List<Autor> listSalida = autorService.listaAutorNombreLike(nombreCompleto);
		 if (listSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
	}
	//CONSULTA DE AUTORES POR NOMBRE
	@GetMapping("/listaAutoresPorNombreLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaAutoresPorNombreLike(@PathVariable("var") String nombreCompleto){
		List<Autor> listaSalida = null;
		if(nombreCompleto.equals("todos")) {
			listaSalida = autorService.listadoAutores();
		}else {
			listaSalida = autorService.listaAutorNombreLike(nombreCompleto + "%");
		}
		return ResponseEntity.ok(listaSalida);
	}
}
