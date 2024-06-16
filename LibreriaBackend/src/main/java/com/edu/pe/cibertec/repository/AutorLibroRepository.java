package com.edu.pe.cibertec.repository;

import com.edu.pe.cibertec.entity.AutorLibro;
import com.edu.pe.cibertec.entity.AutorLibroPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorLibroRepository extends JpaRepository<AutorLibro, AutorLibroPk> {
}