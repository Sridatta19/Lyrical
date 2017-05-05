package com.example.service;

import com.example.dao.LyricRepository;
import com.example.dao.SongRepository;
import com.example.data.Lyric;
import com.example.data.Song;
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

    @Autowired
    private SongRepository songRepository;

    public Flux<Lyric> findAllLyrics() {
        return lyricRepository.findAll();
    }

    public Mono<Lyric> findById(String lyricId) {
        return lyricRepository.findById(lyricId);
    }

    public Mono<Song> addLyricToSong(String songId, String content){
        Mono<Lyric> lyric = Mono.just(new Lyric(songId, content)).flatMap(lyricRepository::save);
        Mono<Song> song = songRepository.findById(songId);
        return Flux.zip(lyric, song).map(a -> a.getT2().addLyric(a.getT1())).flatMap(songRepository::save).singleOrEmpty();
    }

    public Mono<Lyric> likeLyric(String id) {
        return lyricRepository.findById(id).doOnNext(Lyric::like).flatMap(lyricRepository::save);
    }

    public Mono<Void> deleteLyric(String objectId){
        return lyricRepository.deleteById(objectId);
    }

    public Flux<Lyric> findBySongId(String songId) {
        return lyricRepository.findAll().filter(l -> l.getSongId().equals(songId));
    }
}
