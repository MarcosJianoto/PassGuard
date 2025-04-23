package com.passguard.dtos;

public record UserPasswordOnlyEmailAndPasswordDTO(String email, String password, String category, String description) {
}
