package com.myuser.management.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
private UserDetailsService userDetailsService;
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user").password("password").roles("USER")
//  				.and().withUser("admin").password("pass").roles("ADMIN", "USER");
auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
   }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test/**").hasRole("USER")
                .antMatchers("/user/create").permitAll()
                .antMatchers("/role/create").hasRole("USER")
                .and().httpBasic()
                .and().csrf().disable();
    }

}
