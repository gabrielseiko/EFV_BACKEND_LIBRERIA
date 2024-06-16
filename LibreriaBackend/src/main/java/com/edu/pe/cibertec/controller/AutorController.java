package com.edu.pe.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.pe.cibertec.entity.Autor;
import com.edu.pe.cibertec.service.AutorServiceImpl;



import org.springframework.ui.Model;

@Controller
public class AutorController {

	@Autowired
	private AutorServiceImpl servicio;



	//LISTADO DE AUTORES
	@RequestMapping("/listarAutores")
	public String listarAutores(Model m) {
		List<Autor> listaAutores = servicio.ListadoAutores();
		m.addAttribute("autores", listaAutores);
		return "listarAutores";
	}
	
}
