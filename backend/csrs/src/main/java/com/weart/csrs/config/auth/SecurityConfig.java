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

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
////        로그인시 필요한 정보를 가져옴.
//        auth.userDetailsService(customUserTypesOAuth2UserService)  //유저 정보를 어느 서비스에서 가져올지 결정.
//                .passwordEncoder(new BCryptPasswordEncoder());  //Password 인코더는 passwordEncoder(BCrypt 사용)
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//  인증을 무시할 경로 설정
        web.ignoring().antMatchers("/css/**", "/script/**", "image/**");
    }

//    public String logout(HttpServletRequest request, HttpServletResponse response){
//        new SecurityContextLogoutHandler().logout(request,response, SecurityContextHolder.getContext().getAuthentication());
//        return "/logout";
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http 관련한 인증 설정 가능
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
//                userInfoEndpoint() 는 OAuth2 로그인 성공 후 사용자 정보를 가져올 때 설정을 담당함.
                    .userService(customUserTypesOAuth2UserService);
        //        소셜 로그인의 경우는 조금 다른데, Security Config에 서비스 클래스를 명시해주는 것은 똑같지만 UserService 인터페이스를 구현하는 것이 아닌,
        //        OAuth2UserService<R extends OAuth2UserRequest, U extends OAuth2User> 인터페이스를 구현한 클래스를 걸어주어야 합니다.
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


