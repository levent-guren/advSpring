package com.advspring.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.advspring.service.TokenService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTFilter extends OncePerRequestFilter {
	@Autowired
	private TokenService tokenService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		try {
			if (authHeader != null && authHeader.startsWith("Bearer ")) {
				// Autherization header'ı gönderilmiş ise ve "Bearer " ile başlıyorsa
				String token = authHeader.substring(7);
				if (!"".equals(token)) {
					// token gönderilmiş ise
					Claims claims = tokenService.tokenKontrol(token);
					String name = claims.getId();

					@SuppressWarnings("unchecked")
					ArrayList<String> roller = claims.get("roller", ArrayList.class);
					List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
					// String[] içindeki her bir rol için SimpleGrantedAuthority objesi oluşturup
					// authorities listesine ekledik.
					if (roller != null) {
						roller.forEach(r -> authorities.add(new SimpleGrantedAuthority("ROLE_" + r)));
					}

					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(name,
							"", authorities);
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception ex) {
			// jwt token kontrolü sırasında hata oluştuysa bir şey yapma
			ex.printStackTrace();
			// System.err.println("jwt token error: " + ex.getMessage());
		}
		filterChain.doFilter(request, response);

	}

}
