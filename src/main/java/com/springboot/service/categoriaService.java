package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Categoria;
import com.springboot.repository.categoriaRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class categoriaService {
	@Autowired
	categoriaRepository cateRepository;
	
	public List<Categoria> listar(){
		return cateRepository.findAll();
	}

	public Optional<Categoria> getOne(long id) {
		return cateRepository.findById(id);
	}
	
	public void save(Categoria catego) {
		cateRepository.save(catego);
	}
	public Optional<Categoria> findById(Long id) {
	    return cateRepository.findById(id);
	}

	public void delete(long id) {
		cateRepository.deleteById(id);
	}
	
	public boolean existsById(long id) {
		return cateRepository.existsById(id);
	}
        
}
