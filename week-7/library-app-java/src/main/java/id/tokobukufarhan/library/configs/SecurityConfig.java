package id.tokobukufarhan.library.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
 * kelas untuk filter jwt, request yang masuk harus dicek token jwtnya
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
  @Autowired
  UserDetailsService userDetailsService;

  @Autowired
  JwtFilter jwtFilter;

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // disable csrf
    http.csrf(csrf -> {
      csrf.disable();
    });

    // session management
    http.sessionManagement(session -> {
      session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    });



    // authorize request
    http.authorizeHttpRequests(auth -> {
      auth.requestMatchers("/hello").permitAll()
          .requestMatchers("/users/**").permitAll()
          // .requestMatchers("/admin/**").hasRole("ADMIN")
          .requestMatchers("/guest/**").permitAll()
          //karena ada method pattern kena cors dikasih hasRole juga kena cors, tapi pake preautorize aman
          // .requestMatchers(HttpMethod.GET,"/books/**").hasRole("ADMIN")
          .requestMatchers("/books/**").permitAll()
          .requestMatchers(HttpMethod.GET, "/files/**").permitAll()
          .anyRequest().fullyAuthenticated();
      // auth.anyRequest().permitAll();
    });

    //set authentication provider
    http.authenticationProvider(authenticationProvider());

    //set filter
    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    // basic auth
    // http.httpBasic(Customizer.withDefaults());

    return http.build();
  }

  /*
   * untuk mengautentikasi user yang mau akses request dan/atau login
   */
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration AuthenticationConfiguration)
      throws Exception {
    return AuthenticationConfiguration.getAuthenticationManager();
  }

  /*
   * provider untuk mencari email dan dan match passnya
   */

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(passwordEncoder());
    authenticationProvider.setUserDetailsService(userDetailsService);
    return authenticationProvider;
  }

}