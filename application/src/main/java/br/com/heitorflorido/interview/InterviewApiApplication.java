package br.com.heitorflorido.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.heitorflorido")
public class InterviewApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(InterviewApiApplication.class, args);
	}
}
