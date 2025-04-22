package com.passguard.enums;

public enum Category {

	PESSOAL("Pessoal"), SEGWARE("Segware"), GAMES("Games");

	private final String label;

	private Category(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
