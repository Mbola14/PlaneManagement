package com.vehicule.flotte_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.vehicule.flotte_management.security.JWTAuthorizationFilter;

@SpringBootApplication
public class FlotteManagementApplication {
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user").permitAll()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/avions").permitAll()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/kilometrages/avions/{planeId}").permitAll()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/onemonth").permitAll()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/threemonth").permitAll()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/saveImg").permitAll()
				.anyRequest().authenticated();
			http.cors();
		}
	}

	@Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
                registry.addMapping("/onemonth").allowedMethods("POST", "PUT", "DELETE", "OPTIONS").allowedOrigins("*").allowedHeaders("*").maxAge(-1).allowCredentials(false);
                registry.addMapping("/threemonth").allowedMethods("POST", "PUT", "DELETE", "OPTIONS").allowedOrigins("*").allowedHeaders("*").maxAge(-1).allowCredentials(false);
                registry.addMapping("/user").allowedMethods("POST", "PUT", "DELETE", "OPTIONS").allowedOrigins("*").allowedHeaders("*").maxAge(-1).allowCredentials(false);
				registry.addMapping("/avions").allowedMethods("POST", "PUT", "DELETE", "OPTIONS").allowedOrigins("*").allowedHeaders("*").maxAge(-1).allowCredentials(false);
				registry.addMapping("/kilometrages/avions/{planeId}").allowedMethods("POST", "PUT", "DELETE", "OPTIONS").allowedOrigins("*").allowedHeaders("*").maxAge(-1).allowCredentials(false);
				registry.addMapping("/saveImg").allowedMethods("POST", "PUT", "DELETE", "OPTIONS").allowedOrigins("*").allowedHeaders("*").maxAge(-1).allowCredentials(false);
				
				
			}
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(FlotteManagementApplication.class, args);
	}
}
