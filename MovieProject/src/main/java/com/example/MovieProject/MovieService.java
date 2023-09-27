package com.example.MovieProject;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service        //write the database access methods
public class MovieService {

    @Autowired  //let the framework knows that we want the class MovieRepository to be instantiated
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();       //method defined in the parent class MongoRepository
        //return a list of the objects, and its type is defined as we declare the movieRepository extending MongoRepository
    }

    //we can form dynamic queries using different unique Ids other than the imdbId
    //the container object optional is to let java know we can return null if an object id is not correspond to a movie
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

}
