package com.colchonesBriones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   /* @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}123")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        UserDetails sales = User.builder()
                .username("vendedor")
                .password("{noop}123")
                .roles("USER", "VENDEDOR")
                .build();
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, sales, admin);
    }*/

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                        "/",
                        "/index",
                        "/errores/**",
                        "/error",
                        "/webjars/**",
                        "/recursos/**",
                        "/css/**").permitAll()

                
                .requestMatchers(
                        "/articulo/listado",
                        "/categoria/listado",
                        "/agenda/informa",
                        "/agenda/contacto",
                        "").permitAll()
                .requestMatchers(
                        
                        "/articulo/nuevo",
                        "/articulo/guardar",
                        "/articulo/modificar/**",
                        "/articulo/eliminar/**",
                        "/categoria/nuevo",
                        "/categoria/guardar",
                        "/categoria/modificar/**",
                        "/categoria/eliminar/**",
                        "").hasRole("ADMIN")

                        .requestMatchers(
                        "/agenda/listado",
                        "/agenda/nuevo",
                        "/agenda/modificar/**",
                        "/agenda/guardar",
                        "/agenda/eliminar/**",
                        "/cliente/modificar/**",
                        "/cliente/eliminar/**",
                        "/cliente/nuevo",
                         "/cliente/guardar",
                        "/cliente/listado"
                        
                        )
                .hasRole("USER")
                .requestMatchers(
                        "/carrito/agregar/**",
                        "/carrito/eliminar/**",
                        "/carrito/listado")
                .hasRole("USER")
        )
           
              .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling().accessDeniedPage("/errores/403");
        return http.build();

    }
}
