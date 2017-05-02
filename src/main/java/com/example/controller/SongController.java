package com.example.controller;

import com.example.data.Song;
import com.example.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by sridattap on 19/04/17.
 */
@Component
public class SongController {

	@Autowired
	private SongService songService;

	@Bean
	RouterFunction routes(SongService songService){
		return RouterFunctions.route(GET("/songs"), getAllSongs)
				.andRoute(GET("songs/{id}"), getSongById);
	}

	private HandlerFunction getAllSongs = request -> ok().body(songService.findAllSongs(), Song.class);

	private HandlerFunction getSongById = request -> ok().body(songService.findById(request.pathVariable("id")), Song.class);

}
