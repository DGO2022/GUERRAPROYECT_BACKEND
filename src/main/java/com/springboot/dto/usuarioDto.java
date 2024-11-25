package com.springboot.dto;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.multipart.MultipartFile;


public class usuarioDto {

	
	private String nombre;
	private String apellido;
	private Date fechanaci;
	private String dni;
	private String direccion;
	private String telefono;
	private String correo;
    private String contrasena;
	private byte[] cv;
	
	
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
	
	
	
	
	public usuarioDto(String nombre, String apellido, Date fechanaci, String dni, String direccion, String telefono,
			String correo, String contrasena, byte[] cv) {
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
	
	public usuarioDto() {
	}

	

}
