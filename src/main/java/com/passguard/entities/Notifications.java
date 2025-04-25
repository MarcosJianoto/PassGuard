package com.passguard.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "password_history")
public class Notifications {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_password_history")
	@SequenceGenerator(name = "sequence_password_history", sequenceName = "sequence_password_history", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_password_id", nullable = false)
	private UserPasswords userPasswords;

	@Column(name = "notify_at", nullable = false)
	private LocalDate days;

	public Notifications() {

	}

	public Notifications(UserPasswords userPasswords, LocalDate date) {
		this.userPasswords = userPasswords;
		this.days = date;
	}

	public Notifications(Integer id, UserPasswords userPasswords, LocalDate date) {
		super();
		this.id = id;
		this.userPasswords = userPasswords;
		this.days = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserPasswords getUserPasswords() {
		return userPasswords;
	}

	public void setUserPasswords(UserPasswords userPasswords) {
		this.userPasswords = userPasswords;
	}

	public LocalDate getDate() {
		return days;
	}

	public void setDate(LocalDate date) {
		this.days = date;
	}

}
