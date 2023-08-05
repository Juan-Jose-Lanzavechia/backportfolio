package com.portfolio.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/* import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.portfolio.portfolio.Security.Controller.Bean; */

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

/* @Bean
public WebMvcConfigurer corsConfigurer(){
	return new WebMvcConfigurer() {

    @Override
    public void addCorsMappings (CorsRegistry registry){
        registry.addMapping("/**")
        .allowedOriginPatterns("*") //Es para permitor todas las url de origen  
        .allowedOrigins("http://localhost:4200")   
        .allowedMethods("*") //Para permitir los métodos HTTP
        .allowedHeaders("*") //Es para permiitir todas las cabeceras
        .allowCredentials(true) //Para permitir enviar credenciales (cookies, encabezados de autenticación, etc)
        .maxAge(3600); //Para configurar el tiempo máximo de almacenamiento en caché de las opciones pre-vuelo (preflight)
            
    		}    
		};
	}  */
}