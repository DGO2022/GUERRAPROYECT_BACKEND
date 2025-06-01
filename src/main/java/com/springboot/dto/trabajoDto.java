package com.springboot.dto;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.entity.Categoria;
import com.springboot.entity.Usuario;

public class trabajoDto {

	private String titulo;
	private String detalle;
	//private byte[] imagen;
	private Usuario usuario;
	private Categoria categoria;

	public trabajoDto() {
	}

	/*public trabajoDto(String detalle, byte[] imagen, Usuario usuario, Categoria categoria) {
		this.detalle = detalle;
		this.imagen = imagen;
		this.usuario = usuario;
		this.categoria = categoria;
	}*/
	
	public trabajoDto(String titulo, String detalle, Usuario usuario, Categoria categoria) {
		this.detalle = detalle;
		this.detalle = titulo;
		this.usuario = usuario;
		this.categoria = categoria;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/*public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}*/

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
