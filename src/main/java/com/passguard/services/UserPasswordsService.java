package com.passguard.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passguard.dtos.UserPasswordsDTO;
import com.passguard.entities.UserPasswords;
import com.passguard.enums.Category;
import com.passguard.enums.Description;
import com.passguard.enums.Status;
import com.passguard.repository.UserPasswordsRepository;

@Service
public class UserPasswordsService {

	@Autowired
	private UserPasswordsRepository userPasswordsRepository;

	private Boolean existsPassword(UserPasswordsDTO password) {
		return userPasswordsRepository.existsByEmailAndDescription(password.email(), password.description());
	}

	public void saveUserPassword(UserPasswordsDTO password) {

		if (Boolean.TRUE.equals(existsPassword(password))) {
			throw new IllegalArgumentException("Esse e-mail e descrijão já existem!");
		}

		Category category = Category.valueOf(password.category());
		Description description = Description.valueOf(password.description());
		Status status = Status.valueOf(password.status());

		UserPasswords userPasswords = new UserPasswords(password.email(), password.email(), category, description,
				LocalDate.now(), null, status);

	}

	public void saveUserAutomaticPassword(UserPasswordsDTO userPasswordsDTO) {

	}

}
