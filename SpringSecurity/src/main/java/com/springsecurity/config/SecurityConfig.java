package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
		/*Customizer<CsrfConfigurer<HttpSecurity>> configurer=new Customizer<CsrfConfigurer<HttpSecurity>>() {
			
			@Override
			public void customize(CsrfConfigurer<HttpSecurity> t) {
				// TODO Auto-generated method stub
				t.disable();
			}
		};
		return http.csrf(configurer).build(); */
		
		/*http.csrf(customizer->customizer.disable()); // we are disabling csrf because to make http stateless(that means it wont store previous data).
		http.authorizeHttpRequests(request->request.anyRequest().authenticated());
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults()); //if we put this the form login become dummy, like even if you logged out, you have access to page/ url.
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build(); */
		
		return http
		.csrf(customizer->customizer.disable())
		.authorizeHttpRequests(request->request.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.build();
	}
}
