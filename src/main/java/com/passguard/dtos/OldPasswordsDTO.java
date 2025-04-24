package com.passguard.dtos;

import java.time.LocalDate;

public record OldPasswordsDTO(String password, String email, String description, LocalDate changedAt) {

}
