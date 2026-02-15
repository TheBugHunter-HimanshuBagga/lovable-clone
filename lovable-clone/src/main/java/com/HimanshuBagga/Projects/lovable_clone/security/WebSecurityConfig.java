package com.HimanshuBagga.Projects.lovable_clone.security;
/*
        FLOW CHAIN IMPLEMENTED
1.Request Coming from Client
2.Request Enters Security Filter Chain {This is a list of filters like:
UsernamePasswordAuthenticationFilter
JwtAuthenticationFilter (custom)
ExceptionTranslationFilter
etc.}
3.Generates Token Stored in Spring Context but creating a authentication object for further request
4. Stored In Spring Context or Security Context
5. Go to Controllers
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.PasswordManagementDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    // security filter chain impl
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // allow every one to access url starting with /api/** without login with auth without token
                );
        return httpSecurity.build();
    }

    @Bean// used to encrypt the password before saving it into the database
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean// handels login authentications globally for jwt and login purposes
    // Login request -> authentication Manager -> loadUserByUserName -> User from DB -> PasswordEncoder checks Password -> Login Success
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        return authenticationConfiguration.getAuthenticationManager();
    }

}
