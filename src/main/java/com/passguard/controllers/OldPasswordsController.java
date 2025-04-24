package com.passguard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passguard.dtos.OldPasswordsDTO;
import com.passguard.services.OldPasswordsService;

@RestController
@RequestMapping("/history")
public class OldPasswordsController {

	@Autowired
	private OldPasswordsService oldPasswordsService;

	@GetMapping("/{id}")
	public ResponseEntity<OldPasswordsDTO> getOldPasswordById(@PathVariable Integer id) {
		OldPasswordsDTO oldPasswordsDTO = oldPasswordsService.getOldPasswordsById(id);
		return ResponseEntity.ok(oldPasswordsDTO);
	}

	@GetMapping
	public ResponseEntity<List<OldPasswordsDTO>> getAllOldPassword() {
		List<OldPasswordsDTO> oldPasswordsDTOs = oldPasswordsService.getAllPasswordsDTOs();
		return ResponseEntity.ok(oldPasswordsDTOs);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		oldPasswordsService.deleteOldPassword(id);
		return ResponseEntity.ok().build();
	}

}
