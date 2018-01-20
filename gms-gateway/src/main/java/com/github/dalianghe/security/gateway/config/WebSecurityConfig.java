package com.github.dalianghe.security.gateway.config;

import com.github.dalianghe.security.gateway.service.GateUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private GateUserDetailsService gateUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .formLogin().loginPage("/login").defaultSuccessUrl("/admin/index").permitAll()
                .and()
                .logout().logoutUrl("/logout") .logoutSuccessUrl("/login").logoutRequestMatcher(new AntPathRequestMatcher("/logout")).invalidateHttpSession(true)
                .and()
                .authorizeRequests().antMatchers("/**/*.css", "/img/**", "/**/*.js","/api/**","/*/api/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/**").authenticated();
        //http.csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(gateUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        //builder.userDetailsService(gateUserDetailsService);
    }

}
