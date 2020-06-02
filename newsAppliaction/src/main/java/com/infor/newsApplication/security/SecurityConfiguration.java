/*
 * package com.infor.newsApplication.security;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @Configuration public class SecurityConfiguration extends
 * WebSecurityConfigurerAdapter {
 * 
 * //Create Users user/user
 * 
 * 
 * protected void configure(AuthenticationManagerBuilder auth) throws Exception
 * { auth.inMemoryAuthentication().withUser("user1").password("secret1")
 * .roles("USER","ADMIN"); }
 * 
 * 
 * @Override public void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable().authorizeRequests()
 * .antMatchers(HttpMethod.POST,"/createSection").permitAll()
 * .antMatchers(HttpMethod.GET,"/sectionNews/**").permitAll()
 * .antMatchers(HttpMethod.PUT,"/updateSection").permitAll()
 * .antMatchers(HttpMethod.DELETE,"/deleteSection").permitAll()
 * .anyRequest().authenticated(); } }
 */