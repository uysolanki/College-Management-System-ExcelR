package com.excelr.CollegeManagementSystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyWebSecurity //extends WebSecurityConfigurerAdapter
{

	//Authentication
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 auth.inMemoryAuthentication()
//			.withUser("rohit")
//			.password("rohit123")		// cleartext
//	  		.authorities("ADMIN")  		//roles
//	  		.and()
//	  		.withUser("virat")
//	  		.password("virat123")		// cleartext
//	  		.authorities("USER");
//		auth.authenticationProvider(myAuthenticationProvider());  //single point of contact for Authentication

//	}
	
	@Bean
	public AuthenticationProvider myAuthenticationProvider() {
		DaoAuthenticationProvider daoProvider=new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(mySetUserDetailsService());  //helper 1
		daoProvider.setPasswordEncoder(mySetPasswordEncoder());        //helper 2
		return daoProvider;
	}

	@Bean
	public PasswordEncoder mySetPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService mySetUserDetailsService() {
		return new MyUserDetailsService();
	}

	//Authorisation
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//        .anyRequest().authenticated()
//        .and()        
//        .formLogin().loginProcessingUrl("/login").successForwardUrl("/allProducts").permitAll()
//        .and()
//        .cors().and().csrf().disable();
		
		
//        http.authorizeRequests()
//        .antMatchers("/","/allProducts","/addProductForm","/403").hasAnyAuthority("USER","ADMIN")
//        .antMatchers("/updateProductForm/**","/deleteProduct/**").hasAuthority("ADMIN")
//        .anyRequest().authenticated()
//        .and()
//        .formLogin().loginProcessingUrl("/login").successForwardUrl("/allProducts").permitAll()
//        .and()
//        .logout().logoutSuccessUrl("/login").permitAll()
//        .and()
//        .exceptionHandling().accessDeniedPage("/403")
//        .and()
//        .cors().and().csrf().disable();
//
//	}
	
//	@Bean
// 	public PasswordEncoder getPasswordEncoder()
// 	{
// 		return NoOpPasswordEncoder.getInstance();
// 	}
	
	@Configuration
	public class SecurityConfiguration {

	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.authenticationProvider(myAuthenticationProvider());
	        
	        http.authorizeRequests()
	        .requestMatchers("/","/showAllTeachers","/teacherRegistrationForm","/403").hasAnyAuthority("USER","ADMIN")
	        .requestMatchers("/updateTeacherForm/**","/deleteTeacherFE/**").hasAuthority("ADMIN")
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().loginProcessingUrl("/login").successForwardUrl("/").permitAll()
	        .and()
	        .logout().logoutSuccessUrl("/login").permitAll()
	        .and()
	        .exceptionHandling().accessDeniedPage("/403")
	        .and()
	        .cors().and().csrf().disable();
	            
	        return http.build();
	    }

	}

}
