package com.security.oauth.spring_security_oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class SpringSecurityOauthApplication {

	public static void main(String[] args) {
		// Load environment variables from .env
        Dotenv dotenv = Dotenv.configure().load();
		
        
        // Set environment variables
        System.setProperty("GOOGLE_CLIENT_ID", dotenv.get("GOOGLE_CLIENT_ID"));
        System.setProperty("GOOGLE_CLIENT_SECRET", dotenv.get("GOOGLE_CLIENT_SECRET"));
        System.setProperty("GOOGLE_AUTHORIZATION_URI", dotenv.get("GOOGLE_AUTHORIZATION_URI"));
        System.setProperty("GOOGLE_TOKEN_URI", dotenv.get("GOOGLE_TOKEN_URI"));
        System.setProperty("GOOGLE_USER_INFO_URI", dotenv.get("GOOGLE_USER_INFO_URI"));
		

		SpringApplication.run(SpringSecurityOauthApplication.class, args);
	}

}
