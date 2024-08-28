package co.istad.di_resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiResourceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DiResourceApplication.class, args);
	}
	@Value("${spring.application.name}")
	private String appName;
	@Value("${server.port}")
	private Integer appPort;
	@Value("${user.username}")
	private String username;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Name: " + appName);
		System.out.println("Application Port: " + appPort);
		System.out.println("Username: " + username);

	}
}
