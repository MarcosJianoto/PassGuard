package com.passguard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passguard.dtos.UserPasswordsDTO;
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
}
