package com.binary.carShow.security;

import com.binary.carShow.entity.Car;
import com.binary.carShow.exception.AuthEntryPoint;
import com.binary.carShow.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AuthenticationFilter authenticationFilter;
    @Autowired
    private AuthEntryPoint authEntryPoint;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .cors(Customizer.withDefaults())
                .csrf(c -> c.disable())
                .authorizeHttpRequests(
                       auth ->auth.
                               requestMatchers(HttpMethod.POST,"/login").permitAll()
                               .anyRequest()
                               .authenticated())
                               .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling((ex)->ex.authenticationEntryPoint(authEntryPoint))



                .build();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // csrf  Cross site request forgery (CSRF) attack
    //cors
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(bCryptPasswordEncoder().encode("adminPass"))
//                .roles("ADMIN")
//                .build();
//  var user = User.builder()
//          .username("user")
//          .password(bCryptPasswordEncoder().encode("userPass")) //
//          .roles("USER")
//          .build();
//  return  new InMemoryUserDetailsManager(user,admin);
//
//    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
