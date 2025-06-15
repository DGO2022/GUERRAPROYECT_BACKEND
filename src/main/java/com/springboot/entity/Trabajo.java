package com.springboot.entity;


import java.sql.Blob;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Trabajo {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_trabajo;
    private String detalle;
    private String titulo;
    
    //@Lob
    //private byte[] imagen;
    
    @ManyToOne
	private Usuario usuario;
    
    
    @ManyToOne
	private Categoria categoria;
    
    
    //@OneToOne
    //@JoinColumn(name = "id_categoria") 
    //private Categoria categoria;
    
	public Long getId_trabajo() {
		return id_trabajo;
	}
	public void setId_trabajo(Long id_trabajo) {
		this.id_trabajo = id_trabajo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
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
	
	/*public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}*/
	
	/*public Trabajo(String detalle, byte[] imagen, Usuario usuario, Categoria categoria) {
		this.detalle = detalle;
		this.imagen = imagen;
		this.usuario = usuario;
		this.categoria = categoria;
	}*/
	
	public Trabajo(String titulo,String detalle, Usuario usuario, Categoria categoria) {
	this.detalle = detalle;
	this.titulo = titulo;
	this.usuario = usuario;
	this.categoria = categoria;
	}
	public Trabajo() {
	}
	
	
	
	
	
	
    
}
