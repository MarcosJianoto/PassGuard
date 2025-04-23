package com.passguard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passguard.dtos.UserPasswordOnlyEmailAndPasswordDTO;
import com.passguard.dtos.UserPasswordsDTO;
import com.passguard.dtos.UserPasswordsUpdateDTO;
import com.passguard.services.UserPasswordsService;

@RestController
@RequestMapping("/user")
public class UserPasswordsController {

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

	@DeleteMapping("/{id}")
	public ResponseEntity<String> userPasswordDelete(@PathVariable Integer id) {
		userPasswordsService.deletePassword(id);
		return ResponseEntity.ok("Categoria deletada com sucesso!");
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserPasswordsDTO> getUserPasswordById(@PathVariable Integer id) {
		UserPasswordsDTO userPasswordsDTO = userPasswordsService.getUserPasswordId(id);
		return ResponseEntity.ok(userPasswordsDTO);
	}

	@GetMapping
	public ResponseEntity<List<UserPasswordsDTO>> getAllUsersAndPasswords() {
		List<UserPasswordsDTO> usersAndPasswords = userPasswordsService.getAllPasswords();
		return ResponseEntity.ok(usersAndPasswords);
	}

	@GetMapping("/only-password")
	public ResponseEntity<List<UserPasswordOnlyEmailAndPasswordDTO>> getAllEmailAndPasswords() {
		List<UserPasswordOnlyEmailAndPasswordDTO> usersAndPasswords = userPasswordsService.getAllOnlyEmailAndPassword();
		return ResponseEntity.ok(usersAndPasswords);
	}

}
