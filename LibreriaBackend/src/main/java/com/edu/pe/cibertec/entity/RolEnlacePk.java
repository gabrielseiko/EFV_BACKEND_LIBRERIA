package com.edu.pe.cibertec.entity;

import java.util.Objects;

import lombok.Data;

@Data
public class RolEnlacePk {

	private int idRol;
	private int idEnlace;
	
	@Override
	public int hashCode() {
		return Objects.hash(idEnlace, idRol);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePk other = (RolEnlacePk) obj;
		return idEnlace == other.idEnlace && idRol == other.idRol;
	}
}
