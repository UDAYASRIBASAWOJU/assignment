package com.lpu.security2.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableMethodSecurity //for preauthorize and postauthorize
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable());  //cross site request forgery
//		http.sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.NEVER)); //IF_REQUIRED(default), STATELESS
		http.cors(c->{})
				.authorizeHttpRequests(
				(req) -> req.requestMatchers("/register", "/public", "/error", "/csrf").permitAll()
				.requestMatchers("/delete", "/update").hasRole("ADMIN")
				//.requestMatchers("/delete", "/findAll").hasAuthority("ADMIN")
				//.requestMatchers("/update").hasAnyRole("ADMIN", "USER")
				//.requestMatchers("/update").hasAnyAuthority("ADMIN", "USER")
				.anyRequest().authenticated());
		
		//http.formLogin(Customizer.withDefaults());
		http.headers(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowedOrigins(List.of("http://localhost:3000", "URL"));
		config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
		config.setAllowedHeaders(List.of("*"));
		config.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}
}