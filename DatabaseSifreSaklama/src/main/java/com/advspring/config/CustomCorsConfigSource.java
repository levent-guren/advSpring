package com.advspring.config;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class CustomCorsConfigSource implements CorsConfigurationSource {

	@Override
	public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		String origin = request.getHeader(HttpHeaders.ORIGIN);
		// if (origin.equals("http://localhost:63342")) {
		corsConfiguration.addAllowedOrigin(origin);
		// }
		corsConfiguration.addAllowedHeader("Authorization");
		corsConfiguration.setAllowedMethods(Arrays.asList("POST", "GET"));
		corsConfiguration.setMaxAge(3600L);
		return corsConfiguration;
	}

}
