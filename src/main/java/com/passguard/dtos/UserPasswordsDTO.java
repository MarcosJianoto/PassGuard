package com.passguard.dtos;

public record UserPasswordsDTO(Integer id, String email, String password, String category, String description,
		String createdAt, String updatedAt, String status) {
}
