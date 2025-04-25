package com.passguard.services;

import org.springframework.stereotype.Service;

import com.passguard.dtos.NotificationsConfigDTO;
import com.passguard.entities.NotificationsConfig;
import com.passguard.repository.NotificationsConfigRepository;

@Service
public class NotificationsConfigService {

	private NotificationsConfigRepository notificationsConfigRepository;

	public NotificationsConfigService(NotificationsConfigRepository notificationsConfigRepository) {
		this.notificationsConfigRepository = notificationsConfigRepository;
	}

	public void createNotificationsConfig(NotificationsConfigDTO notificationsConfigDTO) {

		if (notificationsConfigRepository.existsById(1)) {
			throw new IllegalArgumentException(
					"Não é possível criar uma nova configuração de notificação, somente desativar!");
		}

		notificationsConfigRepository
				.save(new NotificationsConfig(1, notificationsConfigDTO.days(), notificationsConfigDTO.active()));
	}

	public void alterNotificationsConfig(NotificationsConfigDTO notificationsConfigDTO) {

		NotificationsConfig notificationsConfig = notificationsConfigRepository.findById(1)
				.orElseThrow(() -> new IllegalArgumentException("Notification Config precisa ser criado!"));

		notificationsConfig.setDate(notificationsConfigDTO.days());
		notificationsConfig.setActive(notificationsConfigDTO.active());

		notificationsConfigRepository.save(notificationsConfig);

	}

	public NotificationsConfigDTO getNotificationConfig() {

		Integer id = 1;

		NotificationsConfig notificationsConfig = notificationsConfigRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Old Password not found"));

		return new NotificationsConfigDTO(notificationsConfig.getDate(), notificationsConfig.getActive());

	}
}
