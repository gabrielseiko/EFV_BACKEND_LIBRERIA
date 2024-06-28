package com.edu.pe.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.pe.cibertec.entity.Enlace;
import com.edu.pe.cibertec.entity.Rol;
import com.edu.pe.cibertec.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("Select x from Usuario x where x.user = :#{#usu.user} and x.contrasenia = :#{#usu.contrasenia}")
	public abstract Usuario login(@Param(value = "usu") Usuario bean);
	
	@Query("Select p from Enlace p, RolEnlace pr, Rol r, UsuarioHasRol u where  p.idEnlace = pr.enlace.idEnlace and pr.rol.idRol = r.idRol and r.idRol = u.rol.idRol and u.usuario.idUsuario = ?1 ")
	public abstract List<Enlace> traerEnlacesDeUsuario(int idUsuario);

	@Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.idUsuario = ?1 ")
	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario findByUser(String user);
	
	//LISTA TRABAJADORES CON PARAMETO (TRABAJADORES DEL ADMINISTRADOR)
	@Query("SELECT u FROM Usuario u WHERE u.idRecursivo.idUsuario = :idUsuario ORDER BY u.apellidos DESC")
	public abstract List<Usuario> listaTrabajador(@Param("idUsuario") int idUsuario);
	
	//LISTAR TODOS LOS TRABAJADORES
    @Query("SELECT u FROM Usuario u JOIN u.roles r WHERE r.idRol = 2")
    public abstract List<Usuario> findAllTrabajadores();

    //LISTAR TODOS LOS CLIENTES
    @Query("SELECT u FROM Usuario u JOIN u.roles r WHERE r.idRol = 3")
    public abstract List<Usuario> listarClientes();

}
