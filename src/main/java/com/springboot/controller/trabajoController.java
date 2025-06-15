package com.springboot.controller;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.dto.categoriaDto;
import com.springboot.dto.trabajoDto;
import com.springboot.dto.usuarioDto;
import com.springboot.entity.Categoria;
import com.springboot.entity.Mensaje;
import com.springboot.entity.Trabajo;
import com.springboot.entity.Usuario;
import com.springboot.service.categoriaService;
import com.springboot.service.trabajoService;
import com.springboot.service.usuarioService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/trabajo")
public class trabajoController {

	@Autowired
	private trabajoService trabaService;
	@Autowired
	private usuarioService usuarioService;

	@Autowired
	private categoriaService categoriaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Trabajo>> listar() {
		List<Trabajo> listartrabajo = trabaService.listar();
		return new ResponseEntity<List<Trabajo>>(listartrabajo, HttpStatus.OK);
	}
//BORRAR TRABAJO ANTIGUO, AUUN FUNCIONA
	/*@DeleteMapping("/borrar/{id_trabajo}")
	public ResponseEntity<?> delete(@PathVariable("id_trabajo") long id_trabajo) {
		if (!trabaService.existsById(id_trabajo)) {
			return new ResponseEntity(new Mensaje("Trabajo a eliminar no existe"), HttpStatus.BAD_REQUEST);
		} else {
			trabaService.delete(id_trabajo);
			return new ResponseEntity(new Mensaje("Trabajo eliminada"), HttpStatus.OK);
		}
	}*/

	/*@PostMapping(value = "/crear", consumes = "multipart/form-data")
	public ResponseEntity<?> create(
	        @RequestParam("detalle") String detalle,
	        @RequestParam("usuario") String usuarioJson,
	        @RequestParam("categoria") String categoriaJson,
	        @RequestParam(value = "imagen", required = false) MultipartFile imagen) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();

	        // Convertir los JSON recibidos en objetos Usuario y Categoria
	        Usuario usuario = objectMapper.readValue(usuarioJson, Usuario.class);
	        Categoria categoria = objectMapper.readValue(categoriaJson, Categoria.class);

	        // Crear el objeto Trabajo
	        Trabajo trabajo = new Trabajo();
	        trabajo.setDetalle(detalle);
	        trabajo.setUsuario(usuario);
	        trabajo.setCategoria(categoria);
	        
	        if (imagen != null && !imagen.isEmpty()) {
	            trabajo.setImagen(imagen.getBytes());
	        }

	        // Guardar el trabajo
	        trabaService.save(trabajo);
	        return new ResponseEntity<>(new Mensaje("Trabajo creado exitosamente"), HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(new Mensaje("Error al crear el trabajo: " + e.getMessage()), HttpStatus.BAD_REQUEST);
	    }
	}*/
	
	
	
	/*@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody trabajoDto trabaDTO) {
		Trabajo trabajo = new Trabajo(trabaDTO.getDetalle(),trabaDTO.getImagen(), trabaDTO.getUsuario(), trabaDTO.getCategoria());
		trabaService.save(trabajo);
		return new ResponseEntity<>(new Mensaje("Trabajo insertada"), HttpStatus.OK);
	}*/
	
	@PostMapping(value = "/crear", consumes = "application/json")
	public ResponseEntity<?> create(@RequestBody trabajoDto trabaDto) {
	    // Cargar el usuario desde la base de datos para asegurarse de que existe
	    Optional<Usuario> usuarioOpt = usuarioService.findById(trabaDto.getUsuario().getId_usuario());
	    
	    if (!usuarioOpt.isPresent()) {
	        return new ResponseEntity<>(new Mensaje("El usuario especificado no existe"), HttpStatus.BAD_REQUEST);
	    }

	    Trabajo trabajo = new Trabajo();
	    trabajo.setDetalle(trabaDto.getDetalle());
	    trabajo.setTitulo(trabaDto.getTitulo());
	    trabajo.setUsuario(usuarioOpt.get()); // Asignar el usuario persistido
	    trabajo.setCategoria(trabaDto.getCategoria());

	    // Guardar el trabajo
	    trabaService.save(trabajo);
	    return new ResponseEntity<>(new Mensaje("Trabajo creado exitosamente"), HttpStatus.OK);
	}

	
	/*@PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody trabajoDto trabaDTO, @RequestParam("image") MultipartFile image) {
		Trabajo trabajo = new Trabajo();
    	try {
    		byte[] bin = image.getBytes();
    		Blob imageBlob = new SerialBlob(bin);
    		trabajo = new Trabajo(trabaDTO.getDetalle(),imageBlob, trabaDTO.getUsuario(), trabaDTO.getCategoria());
   
		} catch (Exception e) {
			
		}
        
    	trabaService.save(trabajo);
		return new ResponseEntity<>(new Mensaje("Trabajo insertada"), HttpStatus.OK);
    }*/
	
	//Comversion de blob a byte[]
	/*@PostMapping("/create")
    public ResponseEntity<?> createTrabajo(
            @RequestParam("detalle") String detalle,
            @RequestParam("id_usuario") Long id_usuario,
            @RequestParam("categoria") Integer categoria,
            @RequestParam("imagen") MultipartFile imagen) {
        try {
            // Buscar los objetos UsuarioEntity y CategoriaEntity por su ID
            Optional<Usuario> usuario = usuarioService.findById(id_usuario);
            Optional<Categoria> categoriaId= categoriaService.findById(categoria);

            if (!usuario.isPresent() || !categoria.isPresent()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Si no se encuentra usuario o categoría
            }


            // Crear la entidad TrabajoEntity
            TrabajoEntity trabajoEntity = new TrabajoEntity();
            byte[]binario = imagen.getBytes();
            Blob imageBlob = new SerialBlob(binario);
            trabajoEntity.setDetalle(detalle); // Setear el detalle del problema
            trabajoEntity.setUsuarioEntity(usuario.get()); // Asociar al usuario
            trabajoEntity.setCategoriaEntity(categoria.get()); // Asociar a la categoría
            trabajoEntity.setImagen(imageBlob);

            // Guardar el trabajo en la base de datos
            trabajoService.save(trabajoEntity);

            TrabajoDto trabajoDto = new TrabajoDto();
            trabajoDto.setIdTrabajo(trabajoEntity.getIdTrabajo());
            trabajoDto.setDetalle(trabajoEntity.getDetalle());
            trabajoDto.setImagen(imagen);

            return new ResponseEntity<>(trabajoDto, HttpStatus.CREATED);
        } catch (IOException | SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/



//buscador de trabajo por nombre 
	@GetMapping("/buscar")
	public ResponseEntity<List<Trabajo>> buscar(@RequestParam("keyword") String keyword) {
	    List<Trabajo> resultados = trabaService.buscarPorPalabraClave(keyword);
	    return new ResponseEntity<>(resultados, HttpStatus.OK);
	}


	//Actualizar trabajo
	@PutMapping("/update/{id_trabajo}")
	public ResponseEntity<?> update(@PathVariable("id_trabajo") Long id_trabajo, @RequestBody trabajoDto trabaDto) {
		if (!trabaService.existsById(id_trabajo)) {
			return new ResponseEntity(new Mensaje("No existen datos con este código"), HttpStatus.NOT_FOUND);
		}
		Trabajo trabaj = trabaService.getOne(id_trabajo).get();
		trabaj.setDetalle(trabaDto.getDetalle());
		trabaj.setTitulo(trabaDto.getTitulo());
		//trabaj.setImagen(trabaDto.getImagen());
		trabaj.setUsuario(trabaDto.getUsuario());
		trabaj.setCategoria(trabaDto.getCategoria());

		trabaService.save(trabaj);
		return new ResponseEntity(new Mensaje("Producto Actualizado"), HttpStatus.OK);
	}
	
/*
	//METODO DE FUNCIONALIDAD DE FILTROS
		@GetMapping("/categoria/{id_categoria}")
		public ResponseEntity<List<Trabajo>> listarPorCategoria(@PathVariable("id_categoria") Long id_categoria) {
		    List<Trabajo> trabajosPorCategoria = trabaService.listarPorCategoria(id_categoria);
		    return new ResponseEntity<>(trabajosPorCategoria, HttpStatus.OK);
		}*/

	
	
	// Método para eliminar un trabajo por su ID 
	 @DeleteMapping("/eliminar/{id}")
	 public ResponseEntity<Void> eliminarTrabajo(@PathVariable Long id) {
	     boolean eliminado = trabaService.eliminarTrabajo(id);
	     if (eliminado) {
	         return ResponseEntity.noContent().build(); // 204 No Content: Trabajo eliminado correctamente
	     } else {
	         return ResponseEntity.notFound().build(); // 404 Not Found: Trabajo no encontrado
	     }
	 }
    
   
    



}
