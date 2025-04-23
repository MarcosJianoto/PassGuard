package com.passguard.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.passguard.dtos.UserPasswordsDTO;
import com.passguard.dtos.UserPasswordsUpdateDTO;
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

		return new UserPasswords(password.email(), password.password(), Category.valueOf(password.category()),
				Description.valueOf(password.description()), LocalDate.now(), null, Status.valueOf(password.status()));
	}

	public void saveUserPassword(UserPasswordsDTO password) {
		UserPasswords userPasswords = userDtoToEntity(password);
		userPasswordsRepository.save(userPasswords);
	}

	public void saveUserPasswordWithRandomPassword(UserPasswordsDTO password, Integer lenght) {

		existsPassword(password);

		String generatePassword = GeneratePassword.generatePasswordString(lenght);
		testerPassword(generatePassword, lenght);

		UserPasswords userPasswords = new UserPasswords(password.email(), generatePassword,
				Category.valueOf(password.category()), Description.valueOf(password.description()), LocalDate.now(),
				null, Status.valueOf(password.status()));

		userPasswordsRepository.save(userPasswords);

	}

	public void updateUserPasswordComplete(UserPasswordsUpdateDTO password, Integer id) {

		UserPasswords userPasswords = userPasswordsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Senha não encontrada"));

		userPasswords.setEmail(password.email());
		userPasswords.setPassword(password.password());
		userPasswords.setCategory(Category.valueOf(password.category()));
		userPasswords.setUpdatedAt(LocalDate.now());
		userPasswords.setDescription(Description.valueOf(password.description()));
		userPasswords.setStatus(Status.valueOf(password.status()));

		userPasswordsRepository.save(userPasswords);
	}

	public void updateUserEmailAndPassword(UserPasswordsUpdateDTO password, Integer id) {

		UserPasswords userPasswords = userPasswordsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Senha não encontrada"));

		userPasswords.setEmail(password.email());
		userPasswords.setPassword(password.password());

		userPasswordsRepository.save(userPasswords);
	}

	public void updatePassword(UserPasswordsUpdateDTO password, Integer id) {

		UserPasswords userPasswords = userPasswordsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Senha não encontrada"));

		userPasswords.setPassword(password.password());

		userPasswordsRepository.save(userPasswords);
	}

	public void deletePassword(Integer id) {
		userPasswordsRepository.deleteById(id);
	}

}
