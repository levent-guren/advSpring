package com.advspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.advspring.util.Security;

@Component
public class VeritabaniSifreSaklama implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Database Sifresi saklama test kodu");
		String dbSifresi = "oracle_4U";
		StopWatch watch = new StopWatch("saat 1");
		watch.start("encode 1");
		String encodedPass1 = Security.encode(dbSifresi);
		watch.stop();
		watch.start("encode 2");
		String encodedPass2 = Security.encode(dbSifresi);
		watch.stop();
		System.out.println(encodedPass1);
		System.out.println(encodedPass2);
		watch.start("matches 1");
		System.out.println(Security.matches(dbSifresi, encodedPass1));
		watch.stop();
		watch.start("matches 2");
		System.out.println(Security.matches(dbSifresi, encodedPass2));
		watch.stop();
		System.out.println(watch.prettyPrint());
	}
}
