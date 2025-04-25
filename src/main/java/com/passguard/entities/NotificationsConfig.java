package com.passguard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notifications_config")
public class NotificationsConfig {

	@Id
	private Integer id;

	@Column(name = "days", nullable = false)
	private Integer date;

	@Column(name = "active", nullable = false)
	private Boolean active;

	public NotificationsConfig() {

	}

	public NotificationsConfig(Integer date, Boolean active) {
		this.date = date;
		this.active = active;
	}

	public NotificationsConfig(Integer id, Integer date, Boolean active) {
		super();
		this.id = id;
		this.date = date;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
