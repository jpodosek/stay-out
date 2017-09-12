package com.libertymutual.goforcode.stayout.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/css/**", "/js/**", "/loginalot").permitAll()
				.antMatchers("/admin").hasRole("ADMIN") //roles in spring are always capitalized		
				.anyRequest().authenticated() //any request that comes through security pipeline has to be authenticated
			.and()	
			.formLogin()
				.loginPage("/loginalot");									
	}
	
	@Bean
	//allows spring to get usernames, passwords, and roles; fluent API
	public UserDetailsService userDetailsService() {
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		UserDetails user = User
				.withUsername("jon")
				.password("jon")
				.roles("ADMIN")
				.build();
		manager.createUser(user);
		
		user = User
				.withUsername("guest")
				.password("guest")
				.roles("USER")
				.build();
		manager.createUser(user);
			
		return manager;
	}
	
}
