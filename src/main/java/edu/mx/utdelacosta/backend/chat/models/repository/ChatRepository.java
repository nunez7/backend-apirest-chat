package edu.mx.utdelacosta.backend.chat.models.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.mx.utdelacosta.backend.chat.models.documents.Mensaje;

public interface ChatRepository extends MongoRepository<Mensaje, String>{
	
	public List<Mensaje> findFirst10ByOrderByFechaDesc();
	
}
