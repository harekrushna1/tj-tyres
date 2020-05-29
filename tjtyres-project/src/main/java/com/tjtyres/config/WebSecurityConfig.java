package com.tjtyres.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tjtyres.service.UserService;
import com.tjtyres.service.UserServiceImpl;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig{
	
	/*
	 * @Bean public UserService userService() { return new UserServiceImpl(); }
	 * 
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Bean public DaoAuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService());
	 * authProvider.setPasswordEncoder(passwordEncoder());
	 * 
	 * return authProvider; }
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.authenticationProvider(authenticationProvider()); }
	 */
	
//	@Override
//	   protected void configure(HttpSecurity http) throws Exception {
//			/*
//			 * http .authorizeRequests()
//			 * .antMatchers("/").hasAnyAuthority("admin","ADMIN_ROLE","USER_ROLE")
//			 * .anyRequest().authenticated() .and() .formLogin() .permitAll() .and()
//			 * .logout() .permitAll() .and() .exceptionHandling().accessDeniedPage("/403") ;
//			 */
//			http.httpBasic().and().authorizeRequests()
//		   .antMatchers("/").hasRole("ADMIN")
//		   .and().csrf().disable().headers().frameOptions().disable();
//		http.httpBasic()
//	    .and()
//	    .authorizeRequests()
//	    .antMatchers("/")
//	    .hasRole("admin")
//	    .antMatchers("api/**")
//	    .hasRole("ADMIN_ROLE")
//	    .and()
//	    .formLogin();
//	   }
//	   @Autowired
//	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	      auth
//	         .inMemoryAuthentication()
//	         .withUser("abc@gmail.com").password("12345").roles("admin");
//	   }

}
