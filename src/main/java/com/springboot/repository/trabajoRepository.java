package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Trabajo;

public interface trabajoRepository extends JpaRepository<Trabajo, Long>{

}
