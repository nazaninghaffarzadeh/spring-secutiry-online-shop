package com.nazanin.ecom.proj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
    
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

//define user manually
    // @Bean
    // public UserDetailsService userDetailsService(){


    //     UserDetails user1=User
    //                     .withDefaultPasswordEncoder()
    //                     .username("mahnaz")
    //                     .password("7826")
    //                     .roles("USER")
    //                     .build();
       
    //     return new InMemoryUserDetailsManager(user1);
    // }

//when we have users on data base
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);
       
        return provider;
    }

}
