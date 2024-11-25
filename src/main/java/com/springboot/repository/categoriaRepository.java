package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Categoria;

public interface categoriaRepository extends JpaRepository<Categoria, Long>{

}
