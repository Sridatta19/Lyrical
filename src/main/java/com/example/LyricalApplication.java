package com.example;

import com.example.dao.MovieRepository;
import com.example.data.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

import static java.util.UUID.randomUUID;

@SpringBootApplication
public class LyricalApplication {

	@Bean
	CommandLineRunner demo(MovieRepository movieRepository) {
		return args -> {
			movieRepository
					.deleteAll()
					.subscribe(null, null, () -> Stream.of("Aeon Flux", "Enter the Mono", "Silence of the Lambdas")
							.map(name -> new Movie(randomUUID().toString(), name, randomGenre()))
							.forEach(m -> movieRepository.save(m).subscribe(System.out::println)));
		};
	}

	private String randomGenre(){
		String[] genres = new String[]{"Horror", "Action", "Documentary"};
		return genres[new Random().nextInt(genres.length)];
	}

	public static void main(String[] args) {
		SpringApplication.run(LyricalApplication.class, args);
	}
}