package com.example.employeefilter.secuirty;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;


@EnableWebSecurity
@Component
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigure {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    JwtRequestFilter jwtRequestFilter;
    @Autowired
    AuthenticationProvider authenticationProvider;
    @Autowired
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login", "/api/login/oauth2", "api/auth/*", "api/auth/login", "/login/**","/api/auth/login/**", "/api/vaccation/type/all", "/api/gettokendate",
                                "/api/auth/**", "/api/auth/*", "/api/category/all", "/api/subcategory/{cat_id}",
                                "/swagger-ui/**", "/swagger-ui/*", "api/swagger-ui/index.html", "/swagger-ui.html", "*/images/**", "*/images/*", "*/images/2.JPG", "/imagess/**",
                                "/api/user/image/save", "api/product/getImage/**",  "api/product/getImage/*", "/api/v1/auth/**",
                                "/v2/api-docs",
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-resources",
                                "/swagger-resources/**",
                                "/configuration/ui",
                                "/configuration/security",
                                "/swagger-ui/**",
                                "/webjars/**",
                                "/swagger-ui.html",
                                "/api/product/getForGuest",
                                "/api/product/image/save", "/api/product/image/get",
                                "/actuator/**"

                        ).permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .logout((logout) ->
                        logout.logoutUrl("/api/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                );
        return http.build();
    }

}