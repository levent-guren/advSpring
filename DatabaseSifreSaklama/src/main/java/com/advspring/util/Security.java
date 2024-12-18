package com.advspring.util;

import java.util.Base64;

import org.jasypt.util.text.AES256TextEncryptor;

public class Security {
	private static AES256TextEncryptor textEncrypter = new AES256TextEncryptor();

	public static void main(String[] args) {
		// System.out.println(Base64.getEncoder().encodeToString("abc".getBytes()));

		textEncrypter.setPassword(new String(Base64.getDecoder().decode("YWJj".getBytes())));
//		String enc = textEncrypter.encrypt("Merhaba");
//		System.out.println(enc);
//		String dec = textEncrypter.decrypt(enc);
//		System.out.println(dec);

		String val = "s/WqLu+90I/IyvDizJ/GN9dVyqvyS+L2IvX6PZ9eYfScGoAZPmpRQp1c2RjnerNm";
		System.out.println(textEncrypter.decrypt(val));
	}

}
