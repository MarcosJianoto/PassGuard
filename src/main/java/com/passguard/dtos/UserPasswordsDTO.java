package com.passguard.dtos;

import java.time.LocalDate;

import com.passguard.enums.Category;
import com.passguard.enums.Description;
import com.passguard.enums.Status;

public record UserPasswordsDTO(Integer id, String email, String password, Category category, Description description,
		LocalDate createdAt, LocalDate updatedAt, Status status) {

}
