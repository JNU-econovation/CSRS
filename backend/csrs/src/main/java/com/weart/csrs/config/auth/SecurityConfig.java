package com.weart.csrs.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customUserTypesOAuth2UserService;

    @Override

    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/css/**", "/script/**", "image/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .headers().frameOptions().disable()
//                .and()
//                    .authorizeHttpRequests()
//                    .antMatchers("/", "/css/**", "/images/**",
//                            "/js/**", "/h2-console/**").permitAll()
//                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
//                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console/**")
                .permitAll()
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customUserTypesOAuth2UserService);
        http.cors().and().csrf().disable();
    }
}
