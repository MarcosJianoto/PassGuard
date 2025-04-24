package com.passguard.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "password_history")
public class OldPasswords {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_password_history")
	@SequenceGenerator(name = "sequence_password_history", sequenceName = "sequence_password_history", allocationSize = 1)
	private Integer id;

	@Column(name = "old_password", nullable = false)
	private String password;

	@Column(name = "email_password", nullable = false)
	private String email;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "changed_at", nullable = false)
	private LocalDate changedAt;

	public OldPasswords() {

	}

	public OldPasswords(String password, String email, String description, LocalDate changedAt) {
		this.password = password;
		this.email = email;
		this.description = description;
		this.changedAt = changedAt;
	}

	public OldPasswords(Integer id, String password, String email, String description, LocalDate changedAt) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.description = description;
		this.changedAt = changedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(LocalDate changedAt) {
		this.changedAt = changedAt;
	}

}
