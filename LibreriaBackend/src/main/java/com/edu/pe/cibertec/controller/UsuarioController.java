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

import com.edu.pe.cibertec.entity.Autor;
import com.edu.pe.cibertec.entity.Rol;
import com.edu.pe.cibertec.entity.Usuario;
import com.edu.pe.cibertec.entity.UsuarioHasRol;
import com.edu.pe.cibertec.entity.UsuarioRolPk;
import com.edu.pe.cibertec.repository.UsuarioRepository;
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
	//GENERAL
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
	
	
	//CRUD TRABAJADOR
	
    //LISTAR TODOS LOS TRABAJADORES
    @GetMapping("/trabajadores")
    public ResponseEntity<List<Usuario>> listarTrabajadores() {
        List<Usuario> trabajadores = usuarioService.findAllTrabajadores();
        return ResponseEntity.ok(trabajadores);
    }
	//LISTAR TRABAJADOR DE ADMINISTRADOR
    @GetMapping("/listarTrabajador/{param}")
    public ResponseEntity<List<Usuario>> listarTrabajador(@PathVariable("param") int idRecursivo) {
        List<Usuario> salida = usuarioService.listarTrabajador(idRecursivo);
        return ResponseEntity.ok(salida);
    }
	
	//REGISTRAR TRABAJADOR
	@PostMapping("/registrarTrabajador")
	@ResponseBody
	public ResponseEntity<?> registrarTrabajador(@RequestBody Usuario objUsuario) {
	    Map<String, Object> salida = new HashMap<>();
	    try {
	        objUsuario.setIdUsuario(0);

	        UsuarioRolPk usuarioRolPk = new UsuarioRolPk();
	        usuarioRolPk.setIdUsuario(objUsuario.getIdUsuario()); 
	        usuarioRolPk.setIdRol(2); 
	        
	        UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
	        usuarioHasRol.setId(usuarioRolPk);
	        
	        Rol rolTrabajador = new Rol();
	        rolTrabajador.setIdRol(2); 
	        
	        objUsuario.getRoles().add(rolTrabajador);
	        
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

	//ACTUALIZAR TRABAJADOR
	@PutMapping("/actualizarTrabajador")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarTrabajador(@RequestBody Usuario objUsuario) {
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
	
	
	//CRUD CLIENTE
	
	//LISTAR TODOS LOS CLIENTES
    @GetMapping("/clientes")
    public ResponseEntity<List<Usuario>> listarClientes() {
        List<Usuario> clientes = usuarioService.listarClientes();
        return ResponseEntity.ok(clientes);
    }
	
   //REGISTRAR CLIENTE
	@PostMapping("/registrarCliente")
	@ResponseBody
	public ResponseEntity<?> registrarCliente(@RequestBody Usuario objUsuario) {
	    Map<String, Object> salida = new HashMap<>();
	    try {
	        objUsuario.setIdUsuario(0);

	        UsuarioRolPk usuarioRolPk = new UsuarioRolPk();
	        usuarioRolPk.setIdUsuario(objUsuario.getIdUsuario()); 
	        usuarioRolPk.setIdRol(3); 
	        
	        UsuarioHasRol usuarioHasRol = new UsuarioHasRol();
	        usuarioHasRol.setId(usuarioRolPk);
	        
	        Rol rolCliente = new Rol();
	        rolCliente.setIdRol(3); 
	        
	        objUsuario.getRoles().add(rolCliente);
	        
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
	
	//VALIDACIONES Y CONSULTA 
	//CONSULA USUARIO POR NOMBRE TRABAJADOR
	@GetMapping("/listaTrabajadorPorNombreLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaTrabajadorPorNombreLike(@PathVariable("var") String nombres){
		List<Usuario> listaSalida = null;
		if(nombres.equals("todos")) {
			listaSalida = usuarioService.findAllTrabajadores();
		}else {
			listaSalida = usuarioService.listaTrabajadorNombreLike(nombres + "%");
		}
		return ResponseEntity.ok(listaSalida);
	}
	//CONSULA USUARIO POR NOMBRE CLIENTE
	@GetMapping("/listaClientePorNombreLike/{var}")
	@ResponseBody
	public ResponseEntity<?> listaClientePorNombreLike(@PathVariable("var") String nombres){
		List<Usuario> listaSalida = null;
		if(nombres.equals("todos")) {
			listaSalida = usuarioService.listarClientes();
		}else {
			listaSalida = usuarioService.listaClienteNombreLike(nombres + "%");
		}
		return ResponseEntity.ok(listaSalida);
	}
	//VALIDACION POR NOMBRE 
	@GetMapping("/validaNombre")
	public String validaNombre (@RequestParam(name ="nombres") String nombres) {
		List<Usuario> listSalida = usuarioService.validaNombreLike(nombres);
		 if (listSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
	}
	//VALIDACION POR APELLIDO 
	@GetMapping("/validaApellidos")
	public String validaApellidos (@RequestParam(name ="apellidos") String apellidos) {
		List<Usuario> listSalida = usuarioService.validaApellidoLike(apellidos);
		 if (listSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
	}
	
	//VALIDACION POR DNI 
	@GetMapping("/validaDni")
	public String validaDni (@RequestParam(name ="dni") String dni) {
		List<Usuario> listSalida = usuarioService.validaDniLike(dni);
		 if (listSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
	}
	//VALIDACION POR EMAIL
	@GetMapping("/validaEmail")
	public String validaEmail (@RequestParam(name ="email") String email) {
		List<Usuario> listSalida = usuarioService.validaEmailLike(email);
		 if (listSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
	}
	//VALIDACION POR USER
	@GetMapping("/validaUser")
	public String validaUser (@RequestParam(name ="user") String user) {
		List<Usuario> listSalida = usuarioService.validaUserLike(user);
		 if (listSalida.isEmpty()) {
			 return "{\"valid\":true}";
		 }else {
			 return "{\"valid\":false}";
		 }
	}
}
