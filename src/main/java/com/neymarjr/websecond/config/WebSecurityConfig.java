package com.neymarjr.websecond.config;


import com.neymarjr.websecond.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

/*
 *created 06/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("userDetailServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/sign_up").permitAll()
                .antMatchers("/home").hasRole("MEMBER")
                .antMatchers("/declareInfo").hasRole("MEMBER")
                .antMatchers("/bill").hasRole("MEMBER")
                .antMatchers("/admin/home", "/admin/listCustomer").hasRole("ADMIN")
                .antMatchers("/").hasRole("MEMBER")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/tinhlai").hasRole("MEMBER")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
    }

}
