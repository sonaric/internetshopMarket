package com.webshop.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by stanislav on 25.10.17.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/products")
                .loginProcessingUrl("/products")
                .defaultSuccessUrl("/products")
                .and()
                .logout()
                .logoutSuccessUrl("/products")
                .and()
        .authorizeRequests()
        .antMatchers("/user/profile").authenticated()
                .antMatchers(HttpMethod.POST, "/products").authenticated()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(new StandardPasswordEncoder("d15m12y1995"));
    }
}
