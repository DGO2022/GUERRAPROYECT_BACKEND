package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.springboot.entity.Trabajo;

public interface trabajoRepository extends JpaRepository<Trabajo, Long>{

	
	 @Query("SELECT t FROM Trabajo t WHERE LOWER(t.titulo) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(t.detalle) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	 List<Trabajo> findByKeyword(@Param("keyword") String keyword);
	 
	/* 
	// ya tienes el método findByKeyword()

	 // Método para buscar trabajos por categoría
	 List<Trabajo> findByCategoria_id_categoria(Long id_categoria);
	 */
}
