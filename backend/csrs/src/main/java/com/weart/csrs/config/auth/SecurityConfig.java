package com.weart.csrs.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

//import static org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry.RequestMatchers.antMatchers;


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
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable()
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
                /*.antMatchers("/h2-console/**")*/
                //.permitAll()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customUserTypesOAuth2UserService);
        http.csrf().disable()
                // 시큐리티는 기본적으로 세션을 사용
                // 여기서는 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                // h2-console 을 위한 설정을 추가
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                // 로그인, 회원가입 API 는 토큰이 없는 상태에서 요청이 들어오기 때문에 permitAll 설정
                .and()
                .authorizeRequests()
                .antMatchers("/", "/auth/**").permitAll();
    }
}


