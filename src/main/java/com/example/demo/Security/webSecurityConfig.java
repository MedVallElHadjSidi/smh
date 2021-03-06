package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class webSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    public void  ConfigurationMvc(AuthenticationManagerBuilder auth) throws  Exception{
        auth.inMemoryAuthentication().withUser("MedVall").password("{noop}1234").roles("ADMIN");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/static/**", "/resources/**","/.*.css","/images/**", "/js/**", "/fonts/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
        .and()
        .logout();
    }
}
