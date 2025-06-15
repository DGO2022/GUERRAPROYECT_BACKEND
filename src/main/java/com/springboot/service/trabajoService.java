package com.springboot.service;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.trabajoDto;
import com.springboot.entity.Trabajo;
import com.springboot.repository.trabajoRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class trabajoService {
	@Autowired
	trabajoRepository trabaRepository;
	
	public List<Trabajo> listar(){
		return trabaRepository.findAll();
	}

	public Optional<Trabajo> getOne(long id) {
		return trabaRepository.findById(id);
	}
	
	public void save(Trabajo traba) {
		trabaRepository.save(traba);
	}

	public void delete(long id) {
		trabaRepository.deleteById(id);
	}
	
	public boolean existsById(long id) {
		return trabaRepository.existsById(id);
	}
	
	
	/*private trabajoDto convertToDto(Trabajo trabajo) {
        trabajoDto dto = new trabajoDto();
        try {
        	dto.setIdTrabajo(trabajo.get());
            dto.setDetalle(trabajo.getDetalle());
         //   dto.setImagen(trabajo.getImagen().getBytes(1,(int)trabajo.getImagen().length())); // Incluye la imagen en Base64
            
		} catch (Exception e) {

		}
  
        return dto;
    }

    private Trabajo convertToEntity(trabajoDto dto) {
        Trabajo trabajo = new Trabajo();
        try {
        	byte[]binario = dto.getImagen().getBytes();
        	Blob imageBlob = new SerialBlob(binario);
        	trabajo.setIdTrabajo(dto.getIdTrabajo());
            trabajo.setDetalle(dto.getDetalle());
            trabajo.setImagen(imageBlob); // Incluye la imagen en Base64
        } catch (Exception e) {
			e.printStackTrace();
		}
        return trabajo;
    }*/
	
	public List<Trabajo> buscarPorPalabraClave(String keyword) {
	    return trabaRepository.findByKeyword(keyword);
	}
	/*
	//LISTAR POR CATEGORIA DE TRABAJO
	public List<Trabajo> listarPorCategoria(Long id_categoria) {
	    return trabaRepository.findByCategoria_id_categoria(id_categoria);
	}*/
	
	// Método para eliminar un trabajo por su ID
    
    
	public boolean eliminarTrabajo(Long id) {
	    if (trabaRepository.existsById(id)) {
	        trabaRepository.deleteById(id);
	        return true; // Retorna true si la eliminación es exitosa
	    } else {
	        return false; // Retorna false si no se encuentra el trabajo
	    }
	}



}
