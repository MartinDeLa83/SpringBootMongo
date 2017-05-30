package com.martin.springmongo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.martin.springmongo.entidad.Usuario;
import com.martin.springmongo.repositorio.UsuarioMongoRepository;



@RestController
@RequestMapping(path="/usuario")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioMongoRepository repositorio;
	   
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity insertar (@RequestBody Usuario usuario){		
		repositorio.insert(usuario);		
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listar (){						
		return new ResponseEntity(repositorio.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Usuario> getUsuarioPorId (@PathVariable String id){
		return new ResponseEntity<Usuario>(repositorio.findById(id),HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity borrarPorId (@PathVariable String id){
		repositorio.delete(repositorio.findById(id));
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity actualizar (@RequestBody Usuario usuario){
		repositorio.save(usuario);
		return new ResponseEntity(HttpStatus.OK);
	}


}
