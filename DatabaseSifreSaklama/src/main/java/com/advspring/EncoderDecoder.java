package com.advspring;

import java.util.Base64;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.advspring.util.Security;

@Component
public class EncoderDecoder implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// security sınıfındaki textEncrypter'ı kullanmak için önce password vermek
		// gereklidir.
		// bu password'ü de ortam değişkenlerinde alabilirsiniz.
		// Buradaki password'ümüz abc dir.
		// bu password'ün de program içinde açık olarak saklanmaması için Base64 yöntemi
		// ile gizledik.
		// Ancak Base64 yöntemi geri dönülmesi kolay, güvenli bir yöntem değildir.

		// System.out.println(Base64.getEncoder().encodeToString("abc".getBytes()));
		// YWJj abc Stringinin Base64 'ten encode edilerek geçirilmiş halidir.

		String password = new String(Base64.getDecoder().decode("YWJj".getBytes()));
		Security.setPassword(password);

		String enc = Security.encrypt("Merhaba");
		System.out.println(enc); // gSUAtwUrC5kvq0ykdDfQEfLhYEBVvkjS6abe2hxHx4ulHb1PRCBzby/LXOA/BPRg
		String dec = Security.decrypt(enc);
		System.out.println(dec); // Merhaba

		String val = "s/WqLu+90I/IyvDizJ/GN9dVyqvyS+L2IvX6PZ9eYfScGoAZPmpRQp1c2RjnerNm";
		System.out.println(Security.decrypt(val)); // Merhaba
	}
}
