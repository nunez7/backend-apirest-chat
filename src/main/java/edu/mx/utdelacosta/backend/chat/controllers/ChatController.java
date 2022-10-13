package edu.mx.utdelacosta.backend.chat.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import edu.mx.utdelacosta.backend.chat.models.documents.Mensaje;

@Controller
public class ChatController {
	private String [] colores = {"red", "green", "magenta", "purple", "orange"};
	
	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje")
	public Mensaje recibeMensaje(Mensaje mensaje) {
		//Recibimos el mensaje
		mensaje.setFecha(new Date().getTime());
		if(mensaje.getTipo().equals("NUEVO_USUARIO")) {
			//Agregando color aleatorio
			mensaje.setColor(colores[new Random().nextInt(colores.length)]);
			mensaje.setTexto("Nuevo usuario");
		}
		
		return mensaje;
	}

}
