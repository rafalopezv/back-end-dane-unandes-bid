package com.dane.bid.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/api/login").permitAll()
                .and()
                .logout().logoutUrl("/api/logout").permitAll()
                .and()
                .csrf().disable();
    }
}
