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

import com.edu.pe.cibertec.entity.Reserva;
import com.edu.pe.cibertec.service.ReservaService;
import com.edu.pe.cibertec.util.AppSettings;

@RestController
@RequestMapping("/url/reserva")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@GetMapping
	public ResponseEntity<List<Reserva>> listarReservas(){
		List<Reserva> salida = reservaService.listarReservas();
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> buscarReserva(@PathVariable("id") int idReserva) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Reserva> optionalReserva = reservaService.buscarReserva(idReserva);
	        if (optionalReserva.isPresent()) {
	            salida.put("reserva", optionalReserva.get());
	        } else {
	            salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	           }
	   } catch (Exception e) {
	       e.printStackTrace();
	       salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
	    }
	   return ResponseEntity.ok(salida);
	 }
	
	@PostMapping("/registrarReserva")
	@ResponseBody
	public ResponseEntity<?> registrarReserva(@RequestBody Reserva objReserva) {
		Map<String, Object> salida = new HashMap<>();
		try {
			objReserva.setIdPrestamo(0);
			
			Reserva objSalida = reservaService.registrar(objReserva);
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
	
	@PutMapping("/actualizarReserva")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarReserva(@RequestBody Reserva objReserva) {
		Map<String, Object> salida = new HashMap<>();
		try {

			Reserva objSalida = reservaService.registrar(objReserva);
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
	
	@DeleteMapping("/eliminarReserva/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminarReserva(@PathVariable("id") int idReserva) {
		Map<String, Object> salida = new HashMap<>();
		try {
			reservaService.eliminarReserva(idReserva);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
