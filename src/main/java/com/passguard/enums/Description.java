package com.passguard.enums;

public enum Description {

	GMAIL("Gmail"), OUTLOOK("Outlook"), WHATSAPP("WhatsApp"), FACEBOOK("Facebook"), INSTAGRAM("Instagram"),
	LINKEDIN("LinkedIn"), TWITTER("Twitter"), DISCORD("Discord"), GITHUB("GitHub"), GITLAB("GitLab"), STEAM("Steam"),
	EPIC_GAMES("Epic Games"), NETFLIX("Netflix"), AMAZON("Amazon"), MERCADO_LIVRE("Mercado Livre"), NUBANK("Nubank"),
	ITAU("Itaú"), CAIXA("Caixa Econômica"), UDEMY("Udemy"), PERSONAL_EMAIL("Email Pessoal"),
	WORK_EMAIL("Email Corporativo"), SYSTEM_ACCESS("Acesso a Sistemas"), CLOUD_SERVICE("Serviço de Nuvem"),
	OTHER("Outro");

	private final String label;

	private Description(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
