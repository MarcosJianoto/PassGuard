package com.passguard.utils;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneratePassword {

	private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String DIGITS = "0123456789";
	private static final String SPECIAL = "!@#$%&*()-_=+";
	private static final String ALL = UPPER + LOWER + DIGITS + SPECIAL;

	public static String generatePasswordString(Integer lenght) {

		StringBuilder password = new StringBuilder();
		Random random = new SecureRandom();

		password.append(random.nextInt(UPPER.length()));
		password.append(random.nextInt(LOWER.length()));
		password.append(random.nextInt(DIGITS.length()));
		password.append(random.nextInt(SPECIAL.length()));

		for (int i = 4; i < lenght; i++) {
			password.append(ALL.charAt(random.nextInt(ALL.length())));
		}

		List<Character> chars = password.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Collections.shuffle(chars, random);

		return chars.stream().map(String::valueOf).collect(Collectors.joining());

	}

}
