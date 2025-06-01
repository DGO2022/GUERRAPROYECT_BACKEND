package com.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.usuarioDto;
import com.springboot.dto.usuariomater;
import com.springboot.entity.Usuario;
import com.springboot.repository.usuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class usuarioService {
	@Autowired
	usuarioRepository usuaRepository;
	
	
	public List<Usuario> listar(){
		return usuaRepository.findAll();
	}
	/*public List<usuarioDto> listar(){
		List<Usuario> user= usuaRepository.findAll();
		return user.stream().map(usuariomater::datosusuario).collect(Collectors.toList());
	}
	
	*/
	
	public Optional<Usuario> findById(Long id) {
	    return usuaRepository.findById(id);
	}

	public Optional<Usuario> getOne(long id) {
		return usuaRepository.findById(id);
	}
	
	public void save(Usuario usuario) {
		usuaRepository.save(usuario);
	}

	public void delete(long id) {
		usuaRepository.deleteById(id);
	}
	
	public boolean existsById(long id) {
		return usuaRepository.existsById(id);
	}
	 public Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena) {
	        return usuaRepository.findByCorreoAndContrasena(correo, contrasena);
	    }
	
}
