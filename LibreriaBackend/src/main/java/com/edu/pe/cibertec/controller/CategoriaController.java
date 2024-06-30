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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.pe.cibertec.entity.Categoria;
import com.edu.pe.cibertec.entity.Usuario;
import com.edu.pe.cibertec.service.CategoriaService;
import com.edu.pe.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/categoria")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> lista(){
		List<Categoria> lstSalida = categoriaService.listaCategoria();
		return ResponseEntity.ok(lstSalida);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> buscarCategoria(@PathVariable("id") int idCategoria) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Categoria> optionalCategoria = categoriaService.buscarCategoria(idCategoria);
	        if (optionalCategoria.isPresent()) {
	            salida.put("categoria", optionalCategoria.get());
	        } else {
	            salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	           }
	   } catch (Exception e) {
	       e.printStackTrace();
	       salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	    }
	   return ResponseEntity.ok(salida);
	 }
	
	@GetMapping("/listaCategoriaPorDescripcionLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaCategoriaPorDescripcionLike(@PathVariable("var") String descripcion) {
		List<Categoria> lstSalida = null;
		if (descripcion.equals("todos")) {
			lstSalida = categoriaService.listaCategoria();
		} else {
			lstSalida = categoriaService.listaCategoriaPorDescripcionLike(descripcion + "%");
		}
		return ResponseEntity.ok(lstSalida);
	}

	@PostMapping("/registraCategoria")
	@ResponseBody
	public ResponseEntity<?> insertaCategoria(@RequestBody Categoria obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdCategoria(0);
			
			Categoria objSalida = categoriaService.insertaActualizaCategoria(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO + " Categoria de ID ==> " + obj.getIdCategoria() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualizaCategoria")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaCategoria(@RequestBody Categoria obj) {
		Map<String, Object> salida = new HashMap<>();
		try {

			Categoria objSalida = categoriaService.insertaActualizaCategoria(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO + "Categoria de ID ==> " + obj.getIdCategoria() + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@DeleteMapping("/eliminaCategoria/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaCategoria(@PathVariable("id") int idCategoria) {
		Map<String, Object> salida = new HashMap<>();
		try {
			categoriaService.eliminaCategoria(idCategoria);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO + " Categoria de ID ==> " + idCategoria + "." );
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/validaDescripcionRegistra")
	public String validaDescripcion(@RequestParam(name = "descripcion")String descripcion) {
		 List<Categoria> lstSalida =categoriaService.listaCategoriaPorDescripcionIgual(descripcion);
		 if (lstSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
			
	}
	
	@GetMapping("/validaDescripcionActualiza")
	public String validaDescripcion(@RequestParam(name = "descripcion")String descripcion,
									@RequestParam(name = "idCategoria")int idCategoria) {
		 List<Categoria> lstSalida =categoriaService.listaCategoriaPorDescripcionIgualActualiza(descripcion, idCategoria);
		 if (lstSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
			
	}

}
