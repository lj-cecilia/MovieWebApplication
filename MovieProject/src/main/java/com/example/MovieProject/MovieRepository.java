package com.example.MovieProject;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository     //let the framework knows this is a repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //List<Movie> finAll(); dont need to implement this method by ourselves as it's alreayd defined in the parent class

    Optional<Movie> findMovieByImdbId(String imdbId);
}
