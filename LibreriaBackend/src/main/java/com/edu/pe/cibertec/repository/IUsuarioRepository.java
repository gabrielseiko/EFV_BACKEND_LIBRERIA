package com.edu.pe.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.pe.cibertec.entity.Enlace;
import com.edu.pe.cibertec.entity.Rol;
import com.edu.pe.cibertec.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query("Select r from Rol r, UsuarioHasRol u where r.idRol = u.rol.idRol and u.usuario.idUsuario = ?1")
	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	@Query("SELECT DISTINCT e FROM Enlace e " +
		       "JOIN RolEnlace re ON e.idEnlace = re.enlace.idEnlace " +
		       "JOIN Rol r ON re.rol.idRol = r.idRol " +
		       "JOIN UsuarioHasRol u ON r.idRol = u.rol.idRol " +
		       "WHERE u.usuario.idUsuario = :idUsuario")
		List<Enlace> traerEnlacesDeUsuario(@Param("idUsuario") int idUsuario);


    Usuario findByUser(String user);
	
	
	
	/*  NO VA PERO PORSIACASO LO DEJO
	@Query("Select r from tbl_usuario r, tbl_usuario_has_rol u where r.idUsuario = u.tbl_usuario.idUsuario and u.tbl_rol.idRol = 2 order by r.apellidos desc ")
	public abstract List<Usuario> listaJefePrestamistaTotales();
	
	@Query("Select r from tbl_usuario r, tbl_usuario_has_rol u where r.idUsuario = u.tbl_usuario.idUsuario and u.tbl_rol.idRol = 3 and r.idRecursivo =?1 order by r.apellidos desc ")
	public abstract List<Usuario> listaPrestamistaDeUnJefe(int idUsuario);
	

	@Query("Select r from Usuario r, UsuarioHasRol u where r.idUsuario = u.usuario.idUsuario and u.rol.idRol = 4 and r.usuarioSuperior =?1 order by r.apellidos desc ")
	public abstract List<Usuario> listaPrestamistariosDeUnPrestamista(int idUsuario);
	 */
}
