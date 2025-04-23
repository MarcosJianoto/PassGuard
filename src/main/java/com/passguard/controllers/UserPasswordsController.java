package com.passguard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passguard.dtos.UserPasswordsDTO;
import com.passguard.dtos.UserPasswordsUpdateDTO;
import com.passguard.repository.UserPasswordsRepository;
import com.passguard.services.UserPasswordsService;

@RestController
@RequestMapping("/user")
public class UserPasswordsController {

	@Autowired
	private UserPasswordsRepository userPasswordsRepository;

	@Autowired
	private UserPasswordsService userPasswordsService;

	@PostMapping
	public ResponseEntity<Void> saveUserPassword(@RequestBody UserPasswordsDTO userPasswordsDTO) {
		userPasswordsService.saveUserPassword(userPasswordsDTO);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/{lenght}")
	public ResponseEntity<Void> saveUserAndPasswordRandom(@RequestBody UserPasswordsDTO userPasswordsDTO,
			@PathVariable Integer lenght) {
		userPasswordsService.saveUserPasswordWithRandomPassword(userPasswordsDTO, lenght);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateUserAndPasswordComplete(
			@RequestBody UserPasswordsUpdateDTO userPasswordsUpdateDTO, @PathVariable Integer id) {
		userPasswordsService.updateUserPasswordComplete(userPasswordsUpdateDTO, id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/password/{id}")
	public ResponseEntity<Void> updatePassword(@RequestBody UserPasswordsUpdateDTO userPasswordsUpdateDTO,
			@PathVariable Integer id) {
		userPasswordsService.updatePassword(userPasswordsUpdateDTO, id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/password-random/{id}/{lenght}")
	public ResponseEntity<Void> updateRandomPassword(@PathVariable Integer id, @PathVariable Integer lenght) {
		userPasswordsService.updateRandomPassword(id, lenght);
		return ResponseEntity.ok().build();
	}
}
