package com.passguard.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passguard.entities.Notifications;
import com.passguard.entities.UserPasswords;
import com.passguard.repository.NotificationsRepository;
import com.passguard.repository.UserPasswordsRepository;

@Service
public class NotificationsService {

	@Autowired
	private UserPasswordsRepository userPasswordsRepository;

	@Autowired
	private NotificationsRepository notificationsRepository;

	@Autowired
	private NotificationsConfigService notificationsConfigService;

	public void addNotifications(UserPasswords userPasswords) {

		List<UserPasswords> userPass = userPasswordsRepository.findAll();

		for (UserPasswords user : userPass) {

			Optional<Notifications> listUsersNotifications = notificationsRepository.findById(user.getId());

			if (listUsersNotifications.isPresent()) {
				continue;
			}

			LocalDate date = user.getUpdatedAt();
			LocalDate cutOff = LocalDate.now().minusDays(notificationsConfigService.getNotificationConfig().days());

			if (cutOff.isEqual(date) || cutOff.isBefore(date)) {

				Notifications notifications = new Notifications(userPasswords, date);

			}
		}
	}

	public void removeNotifications(UserPasswords userPasswords) {

		List<Notifications> notifications = notificationsRepository.findAll();

		List<UserPasswords> userPass = userPasswordsRepository.findAll();

		for (Notifications notify : notifications) {

			UserPasswords passwords = notify.getUserPasswords();

			LocalDate updatedAt = passwords.getUpdatedAt();
			LocalDate cutOff = LocalDate.now().minusDays(notificationsConfigService.getNotificationConfig().days());

			if (cutOff.isAfter(updatedAt)) {
				notificationsRepository.deleteById(notify.getId());
			}

		}

	}

}
