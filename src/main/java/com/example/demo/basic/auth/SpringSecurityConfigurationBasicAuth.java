package com.example.demo.basic.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {
	
	  // Adding the roles
	  @Override 
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	  { 
	  auth.inMemoryAuthentication() 
	  .withUser("Zack")
	  .password(passwordEncoder().encode("aayush"))
	  .roles("admin_role") 
	  .and() 
	  .withUser("Aayush")
	  .password(passwordEncoder().encode("Saini"))
	  .roles("student_role"); }

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		// logger.debug("Using default configure(HttpSecurity). If subclasses this will
		// potentially override subclass configure(HttpSecurity).");
		  
		  http.cors();

		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/customer").hasRole("admin_role")
			.antMatchers("/basicauth").hasRole("admin_role")
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.anyRequest().authenticated().and()
		 .formLogin().and()
			.httpBasic();
	}

	/*
	 * protected void configure(HttpSecurity http) throws Exception 
	 * { 
	 * http
	 * 	.authorizeRequests(authorizeRequests -> 
	 * authorizeRequests
	 * .antMatchers("/board/*").hasAnyRole("MEMBER", "BOARD")
	 * .antMatchers("/members/*").hasRole("MEMBER") 
	 * .antMatchers("/").permitAll() )
	 * .httpBasic().realmName("My org ream") 
	 * .and()
	 * .sessionManagement()
	 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS); }
	 */

	/*
	 * 
	 * // Adding the roles
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception 
	 * { 
	 * auth.inMemoryAuthentication() 
	 * .withUser("Zack")
	 * .password("aayush") .roles("admin_role") 
	 * .and() 
	 * .withUser("Aayush")
	 * .password("Saini") .roles("student_role"); }
	 * 
	 * // Configuring the api // according to the roles.
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http. 
	 * httpBasic() 
	 * .and() 
	 * .authorizeRequests()
	 * .antMatchers("/delete").hasRole("admin_role") 
	 * .and() 
	 * .formLogin(); 
	 * }
	 * 
	 */
	  
	  /*
	   * 
	   * @Override
    // Method
    protected void configure(HttpSecurity http)
        throws Exception
    {
 
        http.authorizeRequests()
            .antMatchers("/basic")
            .hasAnyRole("BASIC", "ADMIN")
            .antMatchers("/admin")
            .hasRole("ADMIN")
            .antMatchers("/")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .permitAll()
            .loginPage("/login")
            .usernameParameter("username")
            .and()
            .logout()
            .logoutRequestMatcher(
                new AntPathRequestMatcher("/logout"))
            .permitAll();
    }
	   * 
	   */

	  
	  @Bean
		public PasswordEncoder passwordEncoder() {
			//return NoOpPasswordEncoder.getInstance();
		  
		  return new BCryptPasswordEncoder();
		}
}
