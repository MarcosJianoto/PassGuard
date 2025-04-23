package com.passguard.dtos;

public record UserPasswordsUpdateDTO(String email, String password, String category, String description,
		String status) {

}
