package SpringStudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security)throws Exception{
        return security
                .csrf(AbstractHttpConfigurer::disable) //csrf 설정 끄기
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(        "/auth/login",
                                "/auth/login?error",
                                "/auth/login?logout",
                                "/css/**", "/js/**", "/images/**", "/h2-console/**","*").permitAll()
                        .requestMatchers("/admin/**","/ai/**").hasRole("ADMIN")
                                .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/auth/login") // 커스텀 로그인 페이지
                        .loginProcessingUrl("/auth")
                        .defaultSuccessUrl("/auth/main",true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/auth/login?logout")
                        .permitAll()
                )// H2 콘솔 접근 허용
                .build();
    }

    /**
     * AuthenticationManager 생성
     * @param config
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * 비밀번호 인토딩 설정
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
