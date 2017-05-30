package com.martin.springmongo.repositorio;

import com.martin.springmongo.entidad.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioMongoRepository extends MongoRepository<Usuario, Long> {
    Usuario findByNombre(String nombre);
    Usuario findById(String id);
}
