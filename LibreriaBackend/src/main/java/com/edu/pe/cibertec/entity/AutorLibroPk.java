package com.edu.pe.cibertec.entity;

import java.util.Objects;

public class AutorLibroPk {

	private int idAutor;
	private int idLibro;
	
	@Override
	public int hashCode() {
		return Objects.hash(idAutor, idLibro);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutorLibroPk other = (AutorLibroPk) obj;
		return idAutor == other.idAutor && idLibro == other.idLibro;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	
	
}
