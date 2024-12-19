package com.advspring.util;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Security {
	private static AES256TextEncryptor textEncrypter = new AES256TextEncryptor();
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);

	public static void setPassword(String password) {
		textEncrypter.setPassword(password);
	}

	public static String encrypt(String str) {
		return textEncrypter.encrypt(str);
	}

	public static String decrypt(String str) {
		return textEncrypter.decrypt(str);
	}

	public static String encode(CharSequence password) {
		return encoder.encode(password);
	}

	public static boolean matches(String password, String encodedPassword) {
		return encoder.matches(password, encodedPassword);
	}

}
