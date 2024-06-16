package com.edu.pe.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.edu.pe.cibertec.entity.Categoria;
import com.edu.pe.cibertec.entity.Libro;
import com.edu.pe.cibertec.service.CategoriaService;
import com.edu.pe.cibertec.service.LibroService;
import com.edu.pe.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/libro")
//@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public ResponseEntity<List<Libro>> lista(){
		List<Libro> lstSalida = libroService.listaLibro();
		return ResponseEntity.ok(lstSalida);
	}
	
	@GetMapping("/listaLibroPorTituloLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaLibroPorTituloLike(@PathVariable("var") String titulo) {
		List<Libro> lstSalida = null;
		if (titulo.equals("todos")) {
			lstSalida = libroService.listaLibro();
		} else {
			lstSalida = libroService.listaLibroPorTituloLike(titulo + "%");
		}
		return ResponseEntity.ok(lstSalida);
	}

	@PostMapping("/registraLibro")
	@ResponseBody
	public ResponseEntity<?> insertaLibro(@RequestBody Libro obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdLibro(0);
			
			Libro objSalida = libroService.insertaActualizaLibro(obj);
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

	@PutMapping("/actualizaLibro")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaLibro(@RequestBody Libro obj) {
		Map<String, Object> salida = new HashMap<>();
		try {

			Libro objSalida = libroService.insertaActualizaLibro(obj);
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

	@DeleteMapping("/eliminaLibro/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaLibro(@PathVariable("id") int idLibro) {
		Map<String, Object> salida = new HashMap<>();
		try {
			libroService.eliminaLibro(idLibro);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/validaTituloRegistra")
	public String validaTitulo(@RequestParam(name = "descripcion")String titulo) {
		 List<Libro> lstSalida =libroService.listaLibroPorTituloIgual(titulo);
		 if (lstSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
			
	}

}
