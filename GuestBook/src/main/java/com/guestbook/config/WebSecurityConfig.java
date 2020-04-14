package com.guestbook.config;

import static com.guestbook.Constants.GuestBookURIConstants.ACCESS_DENIED_URI;
import static com.guestbook.Constants.GuestBookURIConstants.ADMIN_URI;
import static com.guestbook.Constants.GuestBookURIConstants.GUEST_URI;
import static com.guestbook.Constants.GuestBookURIConstants.HOME_URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * @author Anis Deepa
 * This class is for configuring the application security using Spring
 * admin and guest users are authenticated and authorized using this configuration
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private GuestBookProperties guestBookProperties;
	
	/**
	 * In memory authentication using Spring security
	 */
	@Override
	public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()
			.withUser(guestBookProperties.getUserName()).password(guestBookProperties.getUserPwd()).roles(guestBookProperties.getUserRole())
			.and()
			.withUser(guestBookProperties.getAdminName()).password(guestBookProperties.getAdminPwd()).roles(guestBookProperties.getAdminRole());
	}
	/**
	 * Authorization configuration for admin and guest users
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(ADMIN_URI).hasRole(guestBookProperties.getAdminRole())
                .antMatchers(GUEST_URI).hasAnyRole(guestBookProperties.getAdminRole(), guestBookProperties.getUserRole())
                .antMatchers(HOME_URI).permitAll()
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage(ACCESS_DENIED_URI);
    }
	/**
	 * PasswordEncoder bean created with NoPasswordEncode option
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	     return NoOpPasswordEncoder.getInstance();
	}
}
