package com.edu.pe.cibertec.security;

import java.io.IOException;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenFilter extends OncePerRequestFilter {

	private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		logger.info(">>> Ingreso doFilterInternal");
		try {
			String token = getToken(req);
			logger.info(">>> Llegó token ==> " + token);
			logger.info(">>> doFilterInternal >> token >> "  + token);

			if (token != null && jwtProvider.validateToken(token)) {
				String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
				logger.info(">>> doFilterInternal >> nombreUsuario >> "  + nombreUsuario);
				UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			logger.error("fail en el método doFilter " + e.getMessage());
		}
		filterChain.doFilter(req, res);
	}

	private String getToken(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();

	    if (headerNames != null) {
	            while (headerNames.hasMoreElements()) {
	            	String headerName = headerNames.nextElement();
	            	logger.info("Header: >> " + headerName + " >> " + request.getHeader(headerName));
	            }
	    }
		String header = request.getHeader("Authorization");
		logger.info(">>> header >>> " + header);
		if (header != null && header.startsWith("Bearer"))
			return header.replace("Bearer ", "");
		return null;
	}
}
