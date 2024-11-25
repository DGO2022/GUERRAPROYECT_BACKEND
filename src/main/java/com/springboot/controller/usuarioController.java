package com.springboot.controller;

import java.sql.Blob;
import java.util.List;
import java.util.Map;
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

import com.springboot.dto.usuarioDto;
import com.springboot.entity.Mensaje;
import com.springboot.entity.Usuario;
import com.springboot.service.usuarioService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuario")
public class usuarioController {

    @Autowired
    private usuarioService usuService;

    // Listar todos los usuarios
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> listarUsuario = usuService.listar();
        return new ResponseEntity<>(listarUsuario, HttpStatus.OK);
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/borrar/{id_usuario}")
    public ResponseEntity<?> delete(@PathVariable("id_usuario") long id_usuario) {
        if (!usuService.existsById(id_usuario)) {
            return new ResponseEntity<>(new Mensaje("Usuario a eliminar no existe"), HttpStatus.BAD_REQUEST);
        } else {
            usuService.delete(id_usuario);
            return new ResponseEntity<>(new Mensaje("Usuario eliminado"), HttpStatus.OK);
        }
    }

    //Crear un nuevo usuario (Registro)
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody usuarioDto usuDTO) {
        Usuario usuario = new Usuario(usuDTO.getNombre(), usuDTO.getApellido(), usuDTO.getFechanaci(), usuDTO.getDni(), usuDTO.getDireccion(),
                usuDTO.getTelefono(), usuDTO.getCorreo(), usuDTO.getContrasena(), usuDTO.getCv());
        usuService.save(usuario);
        return new ResponseEntity<>(new Mensaje("Usuario registrado exitosamente"), HttpStatus.OK);
    }
    
    

    
    //blob a byte[]
    /*@PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody usuarioDto usuDTO, @RequestParam MultipartFile image) {
    	Usuario usuario = new Usuario();
    	try {
    		byte[] bin = image.getBytes();
    		Blob imageBlob = new SerialBlob(bin);
    		usuario = new Usuario(usuDTO.getNombre(), usuDTO.getApellido(), usuDTO.getFechanaci(), usuDTO.getDni(), usuDTO.getDireccion(),
                    usuDTO.getTelefono(), usuDTO.getCorreo(), usuDTO.getContrasena(),imageBlob);
		} catch (Exception e) {
			
		}
        
        usuService.save(usuario);
        return new ResponseEntity<>(new Mensaje("Usuario registrado exitosamente"), HttpStatus.OK);
    }*/
    
    

    // Actualizar usuario existente por ID
    @PutMapping("/update/{id_usuario}")
    public ResponseEntity<?> update(@PathVariable("id_usuario") Long id_usuario, @RequestBody usuarioDto usuDto) {
        if (!usuService.existsById(id_usuario)) {
            return new ResponseEntity<>(new Mensaje("No existen datos con este código"), HttpStatus.NOT_FOUND);
        }
        Usuario usu = usuService.getOne(id_usuario).get();
        usu.setNombre(usuDto.getNombre());
        usu.setApellido(usuDto.getApellido());
        usu.setFechanaci(usuDto.getFechanaci());
        usu.setDni(usuDto.getDni());
        usu.setDireccion(usuDto.getDireccion());
        usu.setTelefono(usuDto.getTelefono());
        usu.setCorreo(usuDto.getCorreo());
        usu.setContrasena(usuDto.getContrasena());
        usu.setCv(usuDto.getCv());

        usuService.save(usu);
        return new ResponseEntity<>(new Mensaje("Usuario actualizado"), HttpStatus.OK);
    }

    
    
    
    // Login de usuario
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String correo = credentials.get("correo");
        String contrasena = credentials.get("contrasena");

        // Verifica si existe un usuario con las credenciales proporcionadas
        Optional<Usuario> usuario = usuService.findByCorreoAndContrasena(correo, contrasena);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(new Mensaje("Login exitoso"));
        } else {
            return new ResponseEntity<>(new Mensaje("Email o contraseña incorrectos"), HttpStatus.UNAUTHORIZED);
        }
    }
}
