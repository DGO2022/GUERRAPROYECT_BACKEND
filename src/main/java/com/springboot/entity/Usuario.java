package com.springboot.entity;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
	private String nombre;
    private String apellido;
    private Date fechanaci;
    private String dni;
    private String direccion;
    private String telefono;
    private String correo;
    private String contrasena;
    
    @Lob
    private byte[] cv;
    
    
    @OneToMany	(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Trabajo> trabajo;


	public Long getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFechanaci() {
		return fechanaci;
	}


	public void setFechanaci(Date fechanaci) {
		this.fechanaci = fechanaci;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	


	public byte[] getCv() {
		return cv;
	}


	public void setCv(byte[] cv) {
		this.cv = cv;
	}


	public List<Trabajo> getTrabajo() {
		return trabajo;
	}


	public void setTrabajo(List<Trabajo> trabajo) {
		this.trabajo = trabajo;
	}

	


	public Usuario(String nombre, String apellido, Date fechanaci, String dni, String direccion,
			String telefono, String correo, String contrasena, byte[] cv) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanaci = fechanaci;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasena = contrasena;
		this.cv = cv;
	}


	public Usuario() {
	}
	
	
	
    
   /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id")
    private Cuenta cuenta;*/
    
    //@OneToOne
   // @JoinColumn(name = "id_cuenta") 
    //@JsonIgnore
    //private Cuenta cuenta;
    
    
    
	
}
	
	
	

