package com.cognizant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class SpringConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user").password("{noop}password").roles("USER")
				.and()
				.withUser("admin").password("{noop}password").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/user").hasAnyRole("USER")
			.antMatchers("/admin").hasAnyRole("ADMIN")
			.and().formLogin().loginPage("/login")
			.successHandler(successHandler)
			.permitAll()
			.and()
			.logout();
	}

}
