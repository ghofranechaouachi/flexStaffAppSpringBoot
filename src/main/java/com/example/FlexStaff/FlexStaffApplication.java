package com.example.FlexStaff;

import com.example.FlexStaff.config.JwtService;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
@EnableJpaRepositories
@SpringBootApplication
@Configuration
@EnableWebMvc
public class FlexStaffApplication  implements CommandLineRunner {
	@Autowired
	private JwtService jwtService;
	public static void main(String[] args)  {

		SpringApplication.run(FlexStaffApplication.class, args);

	}





	@Override
	public void run(String... args) throws Exception {
	}
}
