package com.springsecurity.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.springsecurity.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private MyUserDetailsService userDetailService;
	
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
		.authorizeHttpRequests(request -> request.requestMatchers("/otp", "/validateOTP").permitAll()
		        .anyRequest().authenticated())
		//.authorizeHttpRequests(request->request.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults())
		.cors(Customizer.withDefaults())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.build();
	}
	
	
	//to verify username and password.
	
	/*@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user1= User
				.withDefaultPasswordEncoder() //depricated.
				.username("Deepak")
				.password("D@123")
				.roles("DEVELOPER")
				.build();
		
		UserDetails user2= User
				.withDefaultPasswordEncoder()
				.username("Sowmya")
				.password("S@456")
				.roles("DEVELOPER")
				.build();
				
		
		return new InMemoryUserDetailsManager(user1,user2); 
		 
	}
	*/
	
	/*@Bean
	public AuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider(userDetailService);
		
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); //depricated
		return provider;
	} */
	
	@Bean
    public AuthenticationProvider daoAuthenticationProvider(
            PasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailService);
       // provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance(); // ⚠️ ONLY FOR TESTING
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

	    CorsConfiguration configuration = new CorsConfiguration();

	    configuration.setAllowedOrigins(List.of("http://localhost:4200"));
	    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	    configuration.setAllowedHeaders(List.of("*"));

	    UrlBasedCorsConfigurationSource source =
	            new UrlBasedCorsConfigurationSource();

	    source.registerCorsConfiguration("/**", configuration);

	    return source;
	}
}
