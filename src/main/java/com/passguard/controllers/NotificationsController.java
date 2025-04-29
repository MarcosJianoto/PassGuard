package com.passguard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passguard.dtos.NotificationsSendEmailDTO;
import com.passguard.services.NotificationsService;

@RestController
@RequestMapping("/notifications")
public class NotificationsController {

	@Autowired
	private NotificationsService notificationsService;

	// Endpoint para adicionar notificações
	@PostMapping("/add")
	public ResponseEntity<String> addNotifications() {
		try {
			notificationsService.addNotifications();
			return ResponseEntity.ok("Notificações adicionadas com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro ao adicionar notificações: " + e.getMessage());
		}
	}

	// Endpoint para remover notificações
	@DeleteMapping("/remove")
	public ResponseEntity<String> removeNotifications() {
		try {
			notificationsService.removeNotifications();
			return ResponseEntity.ok("Notificações removidas com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro ao remover notificações: " + e.getMessage());
		}
	}

	@PostMapping("/send-email")
	public List<NotificationsSendEmailDTO> sendEmail() {
		return notificationsService.sendEmailById();
	}
}
