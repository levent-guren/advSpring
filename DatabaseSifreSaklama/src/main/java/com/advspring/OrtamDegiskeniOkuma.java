package com.advspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrtamDegiskeniOkuma implements CommandLineRunner {
	@Value("${databaseSifresi:}")
	private String sifre;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(sifre);
	}
}
