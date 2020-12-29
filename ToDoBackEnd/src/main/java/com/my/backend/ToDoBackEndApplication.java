package com.my.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ToDoBackEndApplication {

	@Autowired
	UserRepository userRepository;
	@Autowired
	NoteRepository noteRepository;
	public static void main(String[] args) {
		SpringApplication.run(ToDoBackEndApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			User k1 = new User("Pero");
			User k2 = new User("Ivana");
			Note n1 = new Note("Skuhati kavu", k1);
			Note n2 = new Note("Oprati rublje", k1);
			Note n4 = new Note("Oprati sebe", k1);
			Note n3 = new Note("Pojesti zelje", k2);

			userRepository.save(k1);
			userRepository.save(k2);
			noteRepository.save(n1);
			noteRepository.save(n2);
			noteRepository.save(n3);
			noteRepository.save(n4);
		};
	}

}
