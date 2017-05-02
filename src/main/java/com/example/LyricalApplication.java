package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.UUID.randomUUID;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class LyricalApplication {

//	@Bean
//	RouterFunction routes(FLuxFlixService service){
//		return RouterFunctions.route(
//			GET("/movies"), request -> ok().body(service.all(), Movie.class))
//		.andRoute(GET("movies/{id}"), request -> ok().body(service.byId(request.pathVariable("id")), Movie.class))
//		.andRoute(GET("movies/{id}/events"),
//			request -> ok()
//				.contentType(MediaType.TEXT_EVENT_STREAM)
//				.body(service.byId(request.pathVariable("id")).flatMapMany(service::streamStreams), MovieEvent.class));
//	}

//	@Bean
//	CommandLineRunner demo(MovieRepository movieRepository) {
//		return args -> {
//			movieRepository
//					.deleteAll()
//					.subscribe(null, null, () -> Stream.of("Aeon Flux", "Enter the Mono", "Silence of the Lambdas")
//							.map(name -> new Movie(randomUUID().toString(), name, randomGenre()))
//							.forEach(m -> movieRepository.save(m).subscribe(System.out::println)));
//		};
//	}

//	private String randomGenre(){
//		String[] genres = new String[]{"Horror", "Action", "Documentary"};
//		return genres[new Random().nextInt(genres.length)];
//	}

	public static void main(String[] args) {
		SpringApplication.run(LyricalApplication.class, args);
	}
}

//@Service
//class FLuxFlixService {
//
//	private final MovieRepository movieRepository;
//
//	FLuxFlixService(MovieRepository movieRepository){
//		this.movieRepository = movieRepository;
//	}
//
//	Flux<MovieEvent> streamStreams(Movie movie){
//		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
//		Flux<MovieEvent> events = Flux.fromStream(Stream.generate(() -> new MovieEvent(movie, new Date(), randomUser())));
//		return Flux.zip(interval, events).map(Tuple2::getT2);
//	}
//
//	private String randomUser(){
//		String[] genres = new String[]{"Sri", "Datta", "Pasum"};
//		return genres[new Random().nextInt(genres.length)];
//	}
//
//	Flux<Movie> all(){
//		return movieRepository.findAll();
//	}
//
//	Mono<Movie> byId(String id){
//		return movieRepository.findOne(id);
//	}
//}
//
//interface MovieRepository extends ReactiveMongoRepository <Movie, String> {
//
//}
//
//@Document
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Data
//class Movie {
//
//	@Id
//	private String id;
//
//	private String title;
//
//	private String genre;
//}
//
//@Data
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//class MovieEvent{
//
//	private Movie movie;
//
//	private Date when;
//
//	private String user;
//}
