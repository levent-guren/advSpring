package com.advspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Autowired
	private CustomCorsConfigSource customCorsConfigSource;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.csrf(AbstractHttpConfigurer::disable)
			.cors(corsConfigurer-> {
				corsConfigurer.configurationSource(customCorsConfigSource);
			})
			.authorizeHttpRequests(authorize -> authorize
					.requestMatchers("/dept").permitAll()
					.requestMatchers("/emp").hasRole("admin")
					.requestMatchers(HttpMethod.GET ,"/test").denyAll()
					.anyRequest().authenticated()
			);
		// @formatter:on
		return http.build();
	}
}
