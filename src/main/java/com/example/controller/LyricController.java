package com.example.controller;

import com.example.data.Lyric;
import com.example.service.LyricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sridattap on 19/04/17.
 */
@RestController
@RequestMapping("/lyrics")
public class LyricController {

    @Autowired
    private LyricService lyricService;

    @GetMapping
    public Flux<Lyric> all(){
        return lyricService.findAllLyrics();
    }

    @GetMapping("/{id}")
    public Mono<Lyric> byId(@PathVariable String lyricId){
        return lyricService.findById(lyricId);
    }
}
