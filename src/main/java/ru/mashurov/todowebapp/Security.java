package ru.mashurov.todowebapp;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/login").anonymous()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/mytasks")
                .and()
                .rememberMe().key("secret");
    }
}
