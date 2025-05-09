package com.passguard.services;

import org.springframework.stereotype.Service;

import com.passguard.dtos.NotificationsConfigDTO;
import com.passguard.entities.NotificationsConfig;
import com.passguard.repository.NotificationsConfigRepository;

@Service
public class NotificationsConfigService {

	private static final Integer CONFIG_ID = 1;

	private NotificationsConfigRepository notificationsConfigRepository;

	public NotificationsConfigService(NotificationsConfigRepository notificationsConfigRepository) {
		this.notificationsConfigRepository = notificationsConfigRepository;
	}

	public void createNotificationsConfig(NotificationsConfigDTO notificationsConfigDTO) {

		if (notificationsConfigRepository.existsById(CONFIG_ID)) {
			throw new IllegalArgumentException(
					"Não é possível criar uma nova configuração de notificação, somente desativar!");
		}

		notificationsConfigRepository.save(
				new NotificationsConfig(CONFIG_ID, notificationsConfigDTO.days(), notificationsConfigDTO.active()));
	}

	public NotificationsConfig existsById() {
		return notificationsConfigRepository.findById(CONFIG_ID)
				.orElseThrow(() -> new IllegalArgumentException("Notification Config precisa ser criado!"));
	}

	public void alterNotificationsConfig(NotificationsConfigDTO notification) {
		NotificationsConfig notificationsConfig = existsById();
		if (notification.days() != null) {
			notificationsConfig.setDate(notification.days());
		}
		if (notification.active() != null) {
			notificationsConfig.setActive(notification.active());
		}
		notificationsConfigRepository.save(notificationsConfig);
	}

	public NotificationsConfigDTO getNotificationConfig() {
		NotificationsConfig notificationsConfig = existsById();
		return new NotificationsConfigDTO(notificationsConfig.getDate(), notificationsConfig.getActive());
	}

	public void deleteById() {
		notificationsConfigRepository.deleteById(CONFIG_ID);
	}
}
