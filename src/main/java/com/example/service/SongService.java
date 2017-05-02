package com.example.service;

import com.example.dao.SongRepository;
import com.example.data.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by sridattap on 19/04/17.
 */
@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Flux<Song> findAllSongs() {
        return songRepository.findAll();
    }

    public Mono<Song> findById(String songId) {
        return songRepository.findOne(songId);
    }
}