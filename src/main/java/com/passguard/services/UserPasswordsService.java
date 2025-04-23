package com.passguard.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.passguard.dtos.UserPasswordsDTO;
import com.passguard.entities.UserPasswords;
import com.passguard.enums.Category;
import com.passguard.enums.Description;
import com.passguard.enums.Status;
import com.passguard.repository.UserPasswordsRepository;
import com.passguard.utils.GeneratePassword;

@Service
public class UserPasswordsService {

	@Autowired
	private UserPasswordsRepository userPasswordsRepository;

	private boolean existsPassword(UserPasswordsDTO password) {

		boolean userPasswords = userPasswordsRepository.existsByEmailAndDescription(password.email(),
				password.description());

		if (Boolean.TRUE.equals(userPasswords)) {
			throw new IllegalArgumentException("Esse e-mail e descrijão já existem!");
		}

		return false;
	}

	public String testerPassword(String generatePassword, Integer lenght) {
		Zxcvbn tester = new Zxcvbn();
		Strength strenghtPassword = tester.measure(generatePassword);
		strenghtPassword.getScore();

		while (strenghtPassword.getScore() < 3) {
			generatePassword = GeneratePassword.generatePasswordString(lenght);
		}

		return generatePassword;
	}

	public UserPasswords userDtoToEntity(UserPasswordsDTO password) {

		existsPassword(password);

		Category category = Category.valueOf(password.category());
		Description description = Description.valueOf(password.description());
		Status status = Status.valueOf(password.status());

		return new UserPasswords(password.email(), password.password(), category, description, LocalDate.now(), null,
				status);
	}

	public void saveUserPassword(UserPasswordsDTO password) {
		UserPasswords userPasswords = userDtoToEntity(password);
		userPasswordsRepository.save(userPasswords);
	}

	public void saveUserPasswordWithRandomPassword(UserPasswordsDTO password, Integer lenght) {

		existsPassword(password);

		Category category = Category.valueOf(password.category());
		Description description = Description.valueOf(password.description());
		Status status = Status.valueOf(password.status());

		String generatePassword = GeneratePassword.generatePasswordString(lenght);
		testerPassword(generatePassword, lenght);

		UserPasswords userPasswords = new UserPasswords(password.email(), generatePassword, category, description,
				LocalDate.now(), null, status);

		userPasswordsRepository.save(userPasswords);

	}

	public void updateUserPassword(UserPasswordsDTO password, Integer id) {

	}

	public void deletePassword(Integer id) {
		userPasswordsRepository.deleteById(id);
	}

}
