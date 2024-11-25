package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Long>{

	   Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena);
}
