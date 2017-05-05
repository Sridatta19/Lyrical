package com.example.controller;

import com.example.data.Lyric;
import com.example.data.Movie;
import com.example.data.MovieEvent;
import com.example.data.Song;
import com.example.service.LyricService;
import com.example.service.MovieService;
import com.example.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by sridattap on 04/05/17.
 */
@Component
public class BaseController {

    @Autowired
    private SongService songService;

    @Autowired
    private LyricService lyricService;

    @Autowired
    private MovieService movieService;

    @Bean
    RouterFunction routes(){
        return RouterFunctions.route(GET("/movies"), getAllMovies)
                .andRoute(GET("/movies/{id}"), getMovieById)
                .andRoute(GET("/movies/{id}/events"), getMovieAndEvents)
                .andRoute(GET("/songs"), getAllSongs)
                .andRoute(GET("/songs/{id}"), getSongById)
                .andRoute(POST("/songs/addSong"), addSong)
                .andRoute(POST("/songs/deleteSong/{id}"), deleteSong)
                .andRoute(GET("/songs/lyrics/{id}"), getLyricsBySong)
                .andRoute(GET("/lyrics"), getAllLyrics)
                .andRoute(GET("/lyrics/{id}"), getLyricById)
                .andRoute(POST("/lyrics/addLyric"), addLyric)
                .andRoute(POST("/lyrics/likeLyric/{id}"), likeLyric)
                ;
    }

    private HandlerFunction<ServerResponse> getMovieAndEvents = request -> ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(movieService.byId(request.pathVariable("id")).flatMapMany(movieService::streamStreams), MovieEvent.class);

    private HandlerFunction<ServerResponse> getAllMovies = request -> ok().body(movieService.all(), Movie.class);

    private HandlerFunction<ServerResponse> getMovieById = request -> ok().body(movieService.byId(request.pathVariable("id")), Movie.class);

    private HandlerFunction<ServerResponse> getAllSongs = request -> ok().body(songService.findAllSongs(), Song.class);

    private HandlerFunction<ServerResponse> getLyricsBySong = request -> ok().body(lyricService.findBySongId(request.pathVariable("id")), Lyric.class);

    private HandlerFunction<ServerResponse> getSongById = request -> ok().body(songService.findById(request.pathVariable("id")), Song.class);

    private HandlerFunction<ServerResponse> deleteSong = request -> ok().body(songService.deleteSong(request.pathVariable("id")), String.class);

    private HandlerFunction<ServerResponse> addSong = request -> ok().body(songService.addSong(request.queryParams("title").get(0)), Song.class);

    private HandlerFunction<ServerResponse> addLyric = request -> ok().body(addALyric(request), Song.class);

    private HandlerFunction<ServerResponse> likeLyric = request -> ok().body(lyricService.likeLyric(request.pathVariable("id")), Lyric.class);

    private Mono<Song> addALyric(ServerRequest request) {
        String songId = request.queryParams("songId").get(0);
        String content = request.queryParams("content").get(0);
        return lyricService.addLyricToSong(songId, content);
    }

//    private HandlerFunction<ServerResponse> addSong = request -> request.bodyToMono(Song.class).doOnNext(songService::addSong).then(ok().build());

    private HandlerFunction<ServerResponse> getAllLyrics = request -> ok().body(lyricService.findAllLyrics(), Lyric.class);

    private HandlerFunction<ServerResponse> getLyricById = request -> ok().body(lyricService.findById(request.pathVariable("id")), Lyric.class);
}
