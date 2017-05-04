package com.example.service;

import com.example.dao.LyricRepository;
import com.example.data.Lyric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sridattap on 19/04/17.
 */
@Service
public class LyricService {

    @Autowired
    private LyricRepository lyricRepository;

    public Flux<Lyric> findAllLyrics() {
        return lyricRepository.findAll();
    }

    public Mono<Lyric> findById(String lyricId) {
        return lyricRepository.findById(lyricId);
    }
}
