package com.example.ExpenseTrackerApp.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")   // Allow all paths
                        //.allowedOrigins("*") // Allow all origins
                        //.allowedOriginPatterns("http://127.0.0.1:*","http://192.168.1.3:*") // ✅ supports wildcards with credentials
                        .allowedOriginPatterns(
                                "http://localhost:*",
                                "http://127.0.0.1:*",
                                "http://192.168.137.1:*",
                                "http://192.168.1.*:*",   // ✅ allow any device on your LAN
                                "http://192.168.1.3:*",    // ✅ explicitly allow your laptop’s IP
                                "https://gobindaexpensetrackerapp.up.railway.app*"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowCredentials(true);
            }
        };
    }
}

