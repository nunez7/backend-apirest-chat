package edu.mx.utdelacosta.backend.chat.models.service;

import java.util.List;

import edu.mx.utdelacosta.backend.chat.models.documents.Mensaje;

public interface ChatService {
	
	public List<Mensaje> obtenerUltimosDiezMensajes();
	
	public Mensaje guardar(Mensaje mensaje);
}
