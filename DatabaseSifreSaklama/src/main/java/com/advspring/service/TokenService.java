package com.advspring.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.advspring.model.RolModel;
import com.advspring.model.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenService {
	// @Value("${SECRET_KEY:WcIZ4NiLYA1McKGGCEE1vrmI8BjJrWnmlvRKa/38U0Hf2TpamF8u3FPcFuJQ5ztdmuXgL06CMQ8Oa5V1HCrZmw==}")
	private String KEY = "WcIZ4NiLYA1McKGGCEE1vrmI8BjJrWnmlvRKa/38U0Hf2TpamF8u3FPcFuJQ5ztdmuXgL06CMQ8Oa5V1HCrZmw==";

	public String generateToken(UserModel userModel) {
		JwtBuilder builder = Jwts.builder();

		Map<String, Object> customKeys = new HashMap<>();
		customKeys.put("roller", userModel.getRoller().stream().map(r -> r.getAdi()).toArray());
		customKeys.put("kullaniciId", userModel.getUsername());
		builder.claims(customKeys);
		Instant tarih = Instant.now().plus(15, ChronoUnit.MINUTES);
		builder = builder.subject("login").id(userModel.getUsername()).issuedAt(new Date())
				.expiration(Date.from(tarih));
		return builder.signWith(getKey()).compact();
	}

	private SecretKey getKey() {
		SecretKey key = Keys.hmacShaKeyFor(KEY.getBytes());
		return key;
	}

	public Claims tokenKontrol(String token) {
		JwtParser builder = Jwts.parser().verifyWith(getKey()).build();
		return builder.parseSignedClaims(token).getPayload();
	}

	public static void keyUret() {
		SecretKey key = Jwts.SIG.HS512.key().build();
		String str = Encoders.BASE64.encode(key.getEncoded());
		System.out.println(str);
	}

	public static void main(String[] args) {
		// keyUret();
		UserModel userModel = new UserModel();
		userModel.setUsername("Levent");
		// userModel.getRoller().add(new RolModel("admin"));
		userModel.getRoller().add(new RolModel("user"));
		String token = new TokenService().generateToken(userModel);
		System.out.println(token);
	}

}
