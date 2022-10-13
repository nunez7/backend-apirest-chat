package edu.mx.utdelacosta.backend.chat.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.utdelacosta.backend.chat.models.documents.Mensaje;
import edu.mx.utdelacosta.backend.chat.models.repository.ChatRepository;

@Service
public class ChatServiceImp implements ChatService {
	
	@Autowired
	private ChatRepository serviceChat;
	
	@Override
	public List<Mensaje> obtenerUltimosDiezMensajes() {
		// TODO Auto-generated method stub
		return serviceChat.findFirst10ByOrderByFechaDesc();
	}

	@Override
	public Mensaje guardar(Mensaje mensaje) {
		// TODO Auto-generated method stub
		return serviceChat.save(mensaje);
	}

}
