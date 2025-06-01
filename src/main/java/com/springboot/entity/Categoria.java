package com.springboot.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Categoria {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    private String nombreCategoria;
    
    
    
    @OneToMany	(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Trabajo> trabajo;
    
    //@OneToOne(mappedBy = "categoria")
    //@JsonIgnore
    //private Trabajo trabajo;


	public Categoria(String nombreCategoria) {
		// TODO Auto-generated constructor stub
	}
	public Long getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	
	public List<Trabajo> getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(List<Trabajo> trabajo) {
		this.trabajo = trabajo;
	}
	
	
	public Categoria(Long id_categoria, String nombreCategoria, List<Trabajo> trabajo) {
		this.id_categoria = id_categoria;
		this.nombreCategoria = nombreCategoria;
		this.trabajo = trabajo;
	}
	public Categoria() {
	}
    
    
}
