package com.laptrinhweb.backend.Security;

import com.laptrinhweb.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public SecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable()) // Tắt CSRF cho mục đích demo, cần bật lại trong production
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/api/auth/register").permitAll() // Cho phép truy cập trang chủ và đăng ký
                        .anyRequest().authenticated() // Tất cả các request khác cần xác thực
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Trang đăng nhập tùy chỉnh của bạn
                        .loginProcessingUrl("/api/auth/login") // URL để xử lý đăng nhập
                        .defaultSuccessUrl("/") // Chuyển hướng sau khi đăng nhập thành công
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // URL để logout
                        .permitAll()
                );

        http.authenticationProvider(authenticationProvider());
        return http.build();
    }
}
