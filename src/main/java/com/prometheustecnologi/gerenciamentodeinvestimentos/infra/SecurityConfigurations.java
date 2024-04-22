package com.prometheustecnologi.gerenciamentodeinvestimentos.infra;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity // -> desliga todas as configurações default do spring security
public class SecurityConfigurations {



    // My enpdoints start from /v1 so this pattern is ok for me
    private static final String API_URL_PATTERN = "/**";

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http,
                                                      HandlerMappingIntrospector introspector) throws Exception
    {
        //
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        // está liberando solicitações para a url(API_URL_PATTERN ) e par ao h2 console
        http.csrf(csrfConfigurer ->
                    csrfConfigurer.ignoringRequestMatchers(mvcMatcherBuilder.pattern(API_URL_PATTERN),
                        PathRequest.toH2Console()));

        http.headers(headersConfigurer ->
                headersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        http.authorizeHttpRequests(auth ->
                auth//mvcMatcherBuilder.pattern(HttpMethod.POST,"/auth")
                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST,"/auth")).permitAll()
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .anyRequest().authenticated()
        );

//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }



    @Bean  // serve para mostrar para spring com injetar o  AuthenticationManager
    public AuthenticationManager authenticationManager (AuthenticationConfiguration configuration ) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean // mostra o tipo de criptografia qu vai ser usado
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }
}

