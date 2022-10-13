package edu.mx.utdelacosta.backend.chat.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import edu.mx.utdelacosta.backend.chat.models.documents.Mensaje;
import edu.mx.utdelacosta.backend.chat.models.service.ChatService;

@Controller
public class ChatController {
	private String [] colores = {"red", "green", "magenta", "purple", "orange"};
	
	@Autowired
	private ChatService service;
	
	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje")
	public Mensaje recibeMensaje(Mensaje mensaje) {
		//Recibimos el mensaje
		mensaje.setFecha(new Date().getTime());
		if(mensaje.getTipo().equals("NUEVO_USUARIO")) {
			//Agregando color aleatorio
			mensaje.setColor(colores[new Random().nextInt(colores.length)]);
			mensaje.setTexto("Nuevo usuario");
		}else {
			service.guardar(mensaje);
		}
		return mensaje;
	}
	
	@MessageMapping("/escribiendo")
	@SendTo("/chat/escribiendo")
	public String escribiendo(String username) {
		return username.concat(" está escribiendo...");
	}
	
	/*@MessageMapping("/historial")
	@SendTo("/chat/historial")
	public String escribiendo(String username) {
		return username.concat(" está escribiendo...");
	}*/

}
