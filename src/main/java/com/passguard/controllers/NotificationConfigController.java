package com.passguard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passguard.dtos.NotificationsConfigDTO;
import com.passguard.services.NotificationsConfigService;

@RestController
@RequestMapping("/notification-config")
public class NotificationConfigController {

	@Autowired
	private NotificationsConfigService notificationsConfigService;

	@PostMapping
	public ResponseEntity<NotificationsConfigDTO> getNotificationConfig(
			@RequestBody NotificationsConfigDTO notificationsConfigDTO) {

		notificationsConfigService.createNotificationsConfig(notificationsConfigDTO);

		return ResponseEntity.ok().build();
	}

	@PutMapping
	public ResponseEntity<NotificationsConfigDTO> alterNotificationConfig(
			@RequestBody NotificationsConfigDTO notificationsConfigDTO) {

		notificationsConfigService.alterNotificationsConfig(notificationsConfigDTO);

		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<NotificationsConfigDTO> getNotificationConfig() {
		NotificationsConfigDTO notificationsConfigDTO = notificationsConfigService.getNotificationConfig();
		return ResponseEntity.ok(notificationsConfigDTO);
	}
}
