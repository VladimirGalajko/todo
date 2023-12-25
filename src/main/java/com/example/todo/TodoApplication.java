package com.example.todo;

import com.example.todo.repos.TodoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner run(TodoService todoService) {
//		return args -> {
//			todoService.sendPostRequest();
//		};
//	}
}
