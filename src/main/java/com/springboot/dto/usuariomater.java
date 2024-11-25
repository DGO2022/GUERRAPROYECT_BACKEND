package com.springboot.dto;

import com.springboot.entity.Usuario;

public class usuariomater {

	public static usuarioDto datosusuario(Usuario usuario) {
		usuarioDto userdto = new usuarioDto();
		userdto.setNombre(usuario.getNombre());
		userdto.setApellido(usuario.getApellido());
		userdto.setFechanaci(usuario.getFechanaci());
		userdto.setDni(usuario.getDni());
		userdto.setDireccion(usuario.getDireccion());
		userdto.setTelefono(usuario.getTelefono());
		userdto.setCorreo(usuario.getCorreo());
		userdto.setContrasena(usuario.getContrasena());
		return userdto;
	}
	
	public static Usuario datosAmodelo(usuarioDto usuariodto) {
		Usuario ussser = new Usuario();
		ussser.setNombre(usuariodto.getNombre());
		ussser.setApellido(usuariodto.getApellido());
		ussser.setFechanaci(usuariodto.getFechanaci());
		ussser.setDni(usuariodto.getDni());
		ussser.setDireccion(usuariodto.getDireccion());
		ussser.setTelefono(usuariodto.getTelefono());
		ussser.setCorreo(usuariodto.getCorreo());
		ussser.setContrasena(usuariodto.getContrasena());
		return ussser;
	}
}
