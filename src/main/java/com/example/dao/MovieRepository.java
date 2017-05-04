package com.example.dao;

import com.example.data.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sridattap on 04/05/17.
 */
@Repository
public interface MovieRepository extends ReactiveMongoRepository <Movie, String> {
}
