package com.hrtek.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private HrUserDetailsService hrUserDetailsService;
	@Autowired
	private CustomAuthenticationHandler customAuthenticationHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable().httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/login", "/forgotpass","/css/**","/images/**", "/dbg/**").permitAll()
			.antMatchers("/init", "/firstlogin").hasAnyAuthority("ACCESS_ACTIVE", "ACCESS_FIRSTLOGIN")
			.antMatchers("/**").hasAnyRole("USER", "ADMIN", "BOSS")
			.antMatchers("/**").hasAuthority("ACCESS_ACTIVE")
			.antMatchers("/admin/**").hasAnyRole("ADMIN", "BOSS")
			.antMatchers("/admin/**").hasAuthority("ACCESS_ACTIVE")
			.antMatchers("/boss/**").hasRole("BOSS")
			.antMatchers("/boss/**").hasAuthority("ACCESS_ACTIVE")
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.successHandler(customAuthenticationHandler)
			.failureUrl("/login?error")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
			.and()
			.exceptionHandling().accessDeniedPage("/login");
//			.and()
//			.rememberMe();
	}
	
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.hrUserDetailsService);
		return daoAuthenticationProvider;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
