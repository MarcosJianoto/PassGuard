package com.passguard.enums;

public enum Status {

	ACTIVE("Ativa"), EXPIRED("Expirada"), TO_CHANGE("Troca necessária"), INACTIVE("Inativa");

	private final String label;

	private Status(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
