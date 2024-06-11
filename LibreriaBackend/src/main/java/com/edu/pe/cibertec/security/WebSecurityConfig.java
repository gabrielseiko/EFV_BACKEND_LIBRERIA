package com.edu.pe.cibertec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	//Encriptar contrasenia
	@Bean
	public BCryptPasswordEncoder encriptarClave() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((requets) ->requets
				.requestMatchers("").permitAll()
				.requestMatchers("")
    			.authenticated())
		.formLogin((form) -> form
				.loginPage("")
				.defaultSuccessUrl("")
				.permitAll()
				)
		.logout((logout) -> logout.permitAll());
    					
		
		return http.build();
	}
	
	//METODO DE LA AUTENTICACION
	@Bean
	public UserDetailsService userDetailsService() {
		return new SecurityLogin();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider configure = new DaoAuthenticationProvider();
		configure.setUserDetailsService(userDetailsService());
		configure.setPasswordEncoder(encriptarClave());
		return configure;
	}
}
