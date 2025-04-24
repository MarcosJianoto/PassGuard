package com.passguard.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.passguard.dtos.OldPasswordsDTO;
import com.passguard.entities.OldPasswords;
import com.passguard.entities.UserPasswords;
import com.passguard.repository.OldPasswordsRepository;

@Service
public class OldPasswordsService {

	private OldPasswordsRepository oldPasswordsRepository;

	public OldPasswordsService(OldPasswordsRepository oldPasswordsRepository) {
		this.oldPasswordsRepository = oldPasswordsRepository;
	}

	public void createOldPasswords(UserPasswords userPasswords) {

		OldPasswords oldPasswords = new OldPasswords();

		oldPasswords.setPassword(userPasswords.getPassword());
		oldPasswords.setEmail(userPasswords.getEmail());
		oldPasswords.setDescription(userPasswords.getDescription().toString());
		oldPasswords.setChangedAt(LocalDate.now());

		oldPasswordsRepository.save(oldPasswords);
	}

	public OldPasswordsDTO getOldPasswordsById(Integer id) {

		OldPasswords oldPasswords = oldPasswordsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Old Password not found"));

		return new OldPasswordsDTO(oldPasswords.getPassword(), oldPasswords.getEmail(), oldPasswords.getDescription(),
				oldPasswords.getChangedAt());

	}

	public List<OldPasswordsDTO> getAllPasswordsDTOs() {
		return oldPasswordsRepository.findAll().stream()
				.map((oldPassword) -> new OldPasswordsDTO(oldPassword.getPassword(), oldPassword.getEmail(),
						oldPassword.getDescription(), oldPassword.getChangedAt()))
				.toList();
	}

	
	
	public void deleteOldPassword(Integer id) {
		oldPasswordsRepository.deleteById(id);
	}

}
