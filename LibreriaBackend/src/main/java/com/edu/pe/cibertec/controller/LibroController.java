package com.edu.pe.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.edu.pe.cibertec.entity.LibroReserva;
import com.edu.pe.cibertec.entity.LibroVenta;
import com.edu.pe.cibertec.service.CategoriaService;
import com.edu.pe.cibertec.service.LibroReservaService;
import com.edu.pe.cibertec.service.LibroService;
import com.edu.pe.cibertec.service.LibroVentaService;
import com.edu.pe.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/libro")
//@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class LibroController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private LibroReservaService reservaService;

	@Autowired
	private LibroVentaService ventaService;

	// LIBRO
	// Listar libros
	@GetMapping
	public ResponseEntity<List<Libro>> lista() {
		List<Libro> lstSalida = libroService.listaLibro();
		return ResponseEntity.ok(lstSalida);
	}

	// Lista libros por categoria
	@GetMapping("/listaLibrosPorCategoria/{categoria}")
	@ResponseBody
	public List<Libro> verLibrosPorCategoria(@PathVariable("categoria") int idCategoria) {
		return libroService.listaLibrosPorcategoria(idCategoria);
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

	// Registra libro
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

	// Actualiza libro
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

	// Elimina libro
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

	// Valida titulo de libro
	@GetMapping("/validaTituloRegistra")
	public String validaTitulo(@RequestParam(name = "descripcion") String titulo) {
		List<Libro> lstSalida = libroService.listaLibroPorTituloIgual(titulo);
		if (lstSalida.isEmpty()) {
			return "{\"valid\":true}";
		} else {
			return "{\"valid\":false}";
		}

	}

	// LIBRO RESERVA
	// Registra libro reserva
	@PostMapping("/registraLibroReserva")
	@ResponseBody
	public ResponseEntity<?> insertaLibroReserva(@RequestBody LibroReserva obj) {
		Map<String, Object> salida = new HashMap<>();

		// validacion solo 1 resgitro por libro
		Optional<LibroReserva> libroExiste = reservaService.validacionLibroReserva(obj.getLibro().getIdLibro());
		if (libroExiste.isPresent()) {
			salida.put("mensaje", "Error: El libro ya tiene un registro en Libro Reserva.");
			return ResponseEntity.status(400).body(salida);
		}
		try {
			obj.setEstado(AppSettings.ACTIVO);

			LibroReserva objSalida = reservaService.insertaActualizaLibroReserva(obj);
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

	// Actualiza libro reserva
	@PutMapping("/actualizaLibroReserva")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaLibroReserva(@RequestBody LibroReserva obj) {
		Map<String, Object> salida = new HashMap<>();
		try {

			LibroReserva objSalida = reservaService.insertaActualizaLibroReserva(obj);
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

	// Elimina libro reserva
	@DeleteMapping("/eliminaLibroReserva/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaLibroReserva(@PathVariable("id") int idLibroReserva) {
		Map<String, Object> salida = new HashMap<>();
		try {
			reservaService.eliminaLibroReserva(idLibroReserva);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	// Valida idLibro en libroReserva
	@GetMapping("validarLibroReserva/{idLibro}")
	public Optional<LibroReserva> validarLibroReserva(@PathVariable int idLibro) {
		return reservaService.validacionLibroReserva(idLibro);
	}

	// LIBRO VENTA
	// Registra libro venta
	@PostMapping("/registraLibroVenta")
	@ResponseBody
	public ResponseEntity<?> insertaLibroVenta(@RequestBody LibroVenta obj) {
		Map<String, Object> salida = new HashMap<>();

		// validacion solo 1 resgitro por libro
		Optional<LibroVenta> libroExiste = ventaService.validacionLibroVenta(obj.getLibro().getIdLibro());
		if (libroExiste.isPresent()) {
			salida.put("mensaje", "Error: El libro ya tiene un registro en Libro Venta.");
			return ResponseEntity.status(400).body(salida);
		}
		try {
			obj.setEstado(AppSettings.ACTIVO);

			LibroVenta objSalida = ventaService.insertaActualizaLibroVenta(obj);
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

	// Actualiza libro venta
	@PutMapping("/actualizaLibroVenta")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaLibroVenta(@RequestBody LibroVenta obj) {
		Map<String, Object> salida = new HashMap<>();
		try {

			LibroVenta objSalida = ventaService.insertaActualizaLibroVenta(obj);
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

	// Elimina libro reserva
	@DeleteMapping("/eliminaLibroVenta/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaLibroVenta(@PathVariable("id") int idLibroVenta) {
		Map<String, Object> salida = new HashMap<>();
		try {
			ventaService.eliminaLibroVenta(idLibroVenta);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	// Valida idLibro en libroVenta
	@GetMapping("validarLibroVenta/{idLibro}")
	public Optional<LibroVenta> validarLibroVenta(@PathVariable int idLibro) {
		return ventaService.validacionLibroVenta(idLibro);
	}

}
