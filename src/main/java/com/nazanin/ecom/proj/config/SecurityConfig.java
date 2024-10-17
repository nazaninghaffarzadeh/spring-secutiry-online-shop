package com.nazanin.ecom.proj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        // //diable defulat login now that everyone can acess without login form 
        // http.csrf(customizer ->customizer.disable());
        // //enable login so that they have now do the login proccess
        // http.authorizeHttpRequests(request ->request.anyRequest().authenticated());
        // //enbele form login for browser
        // http.formLogin(Customizer.withDefaults());
        // // to acces with postman
        // http.httpBasic(Customizer.withDefaults());
        // // make sure make it statelss
        // http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.csrf(customizer ->customizer.disable())
        .authorizeHttpRequests(request ->request.anyRequest().authenticated())
       .formLogin(Customizer.withDefaults())
       .httpBasic(Customizer.withDefaults())
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
        
    }
}
