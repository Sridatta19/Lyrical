package com.example.dao;

import com.example.data.Lyric;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by sridattap on 19/04/17.
 */
public interface LyricRepository extends ReactiveMongoRepository<Lyric, String> {
}
