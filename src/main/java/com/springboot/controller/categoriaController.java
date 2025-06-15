package com.springboot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.categoriaDto;
import com.springboot.entity.Categoria;
import com.springboot.entity.Mensaje;
import com.springboot.service.categoriaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categoria")
public class categoriaController {

	@Autowired
	private categoriaService categoService;

	@GetMapping("/listar")
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> listarCategorias = categoService.listar();
		return new ResponseEntity<List<Categoria>>(listarCategorias, HttpStatus.OK);
	}
	

	@DeleteMapping("/borrar/{id_categoria}")
	public ResponseEntity<?> delete(@PathVariable("id_categoria") long id_categoria) {
		if (!categoService.existsById(id_categoria)) {
			return new ResponseEntity(new Mensaje("categoria a eliminar no existe"), HttpStatus.BAD_REQUEST);
		} else {
			categoService.delete(id_categoria);
			return new ResponseEntity(new Mensaje("categoria eliminada"), HttpStatus.OK);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody categoriaDto categorDTO) {
		Categoria categoria = new Categoria(categorDTO.getNombreCategoria());
		categoService.save(categoria);
		return new ResponseEntity<>(new Mensaje("Categoría insertada"), HttpStatus.OK);
	}

	@PutMapping("/update/{id_categoria}")
	public ResponseEntity<?> update(@PathVariable("id_categoria") Long id_categoria, @RequestBody categoriaDto categoriaDTO) {
		if (!categoService.existsById(id_categoria)) {
			return new ResponseEntity(new Mensaje("No existen datos con este código"), HttpStatus.NOT_FOUND);
		}
		Categoria cate = categoService.getOne(id_categoria).get();
		cate.setNombreCategoria(categoriaDTO.getNombreCategoria());

		categoService.save(cate);
		return new ResponseEntity(new Mensaje("Producto Actualizado"), HttpStatus.OK);
	}
	


}
