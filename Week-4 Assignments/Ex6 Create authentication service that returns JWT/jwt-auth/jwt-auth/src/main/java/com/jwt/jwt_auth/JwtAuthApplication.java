package com.jwt.jwt_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.jwt")  // ✅ This ensures SecurityConfig is detected
public class JwtAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(JwtAuthApplication.class, args);
	}
}
