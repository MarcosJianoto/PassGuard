package com.passguard.entities;

import java.time.LocalDate;

import com.passguard.enums.Category;
import com.passguard.enums.Description;
import com.passguard.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_passwords")
public class UserPasswords {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_user_passwords")
	@SequenceGenerator(name = "sequence_user_passwords", sequenceName = "sequence_user_passwords", allocationSize = 1)
	private Integer id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "category", nullable = false)
	private Category category;

	@Enumerated(EnumType.STRING)
	@Column(name = "description", nullable = false)
	private Description description;

	@Column(name = "created_at", nullable = false)
	private LocalDate createdAt;

	@Column(name = "updated_at")
	private LocalDate updatedAt;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;

	public UserPasswords() {
	}

	public UserPasswords(String email, String password, Category category, Description description, LocalDate createdAt,
			LocalDate updatedAt, Status status) {
		this.email = email;
		this.password = password;
		this.category = category;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	public UserPasswords(Integer id, String email, String password, Category category, Description description,
			LocalDate createdAt, LocalDate updatedAt, Status status) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.category = category;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
