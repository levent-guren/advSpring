package com.advspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.advspring.filter.JWTFilter;

@Configuration
public class SecurityConfig {
	@Autowired
	private CustomCorsConfigSource customCorsConfigSource;
	@Autowired
	private JWTFilter jwtFilter;

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
					.anyRequest().authenticated()
			)
			.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		// @formatter:on
		return http.build();
	}
}
