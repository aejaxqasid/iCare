package com.shaikh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.shaikh.constants.UserRole;

@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	
	private static final String ADMIN = UserRole.ADMIN.name();
	private static final String DOCTOR = UserRole.DOCTOR.name();
	private static final String PATIENT = UserRole.PATIENT.name();
	

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		
		.antMatchers("/user/create","/user/login").permitAll()
		.antMatchers("/patient/create").permitAll()
		
		.antMatchers("/spec/**").hasAuthority(ADMIN)
		.antMatchers("/doctor/**").hasAuthority(ADMIN)
		.antMatchers("/patient/all","/patient/update","/patient/delete").hasAuthority(ADMIN)
		.antMatchers("/appointment/**").hasAuthority(ADMIN)
		
		.antMatchers("/slot/all").hasAnyAuthority(ADMIN, DOCTOR, PATIENT)
		
		.antMatchers("/slot/book").hasAnyAuthority(ADMIN, PATIENT)
		.antMatchers("/slot/book-patient").hasAuthority(PATIENT)
		
		
		
		.antMatchers("/patinet/update").hasAuthority(DOCTOR)
		
		.antMatchers("/patient/**").hasAuthority(PATIENT)
		
		.anyRequest().authenticated()
		
		
		.and()
		.formLogin()
		.loginPage("/user/login")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/user/setup",true)
		.failureUrl("/user/login?error=true")
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/user/login?logout=true")
		;
	}

}
