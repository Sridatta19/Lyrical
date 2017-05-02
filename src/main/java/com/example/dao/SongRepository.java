package com.example.dao;

import com.example.data.Song;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by sridattap on 19/04/17.
 */
public interface SongRepository extends ReactiveMongoRepository<Song, String> {

}
