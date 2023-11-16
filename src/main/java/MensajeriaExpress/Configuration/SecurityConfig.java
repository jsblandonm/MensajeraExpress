package MensajeriaExpress.Configuration;



import io.swagger.v3.oas.models.PathItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


import MensajeriaExpress.Jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
     {
         return http
                 .csrf(AbstractHttpConfigurer::disable)
                 .authorizeHttpRequests(authRequest ->
                         authRequest
                                 .requestMatchers("/auth/**", "/swagger-ui/**", "/api-docs/**" , "/empleados/**").permitAll()
                                 .requestMatchers("/empleados/**").hasAnyAuthority("ADMIN")
                                 .requestMatchers(HttpMethod.PUT,"/empleados//{cedulaEmpleado}/**").hasAnyAuthority("ADMIN")
                                 .requestMatchers("/empleados/**").hasAnyAuthority("ADMIN")
                                 .requestMatchers(HttpMethod.GET,"/clientes/**").hasAuthority("USER")
                                 .anyRequest().authenticated()
                 )
                 .sessionManagement(sessionManager ->
                         sessionManager
                                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .authenticationProvider(authProvider)
                 .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                 .build();
     }

}
