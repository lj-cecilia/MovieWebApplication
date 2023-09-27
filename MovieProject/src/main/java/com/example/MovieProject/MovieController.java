package com.example.MovieProject;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")   //used to map any HTTP request
public class MovieController {

    //first version to test out the getMapping annotation
//    @GetMapping("/")
//     public String allMovies() { return "All movies!";}   //instead of returning a string, better return responseEntity

    //second version to test out the reponse entity
//    @GetMapping("/")
//    public ResponseEntity<String> getAllMovies() {
//        return new ResponseEntity<String>("All movies!", HttpStatus.OK);
//        //on terminal type curl -i and the HTTP link, will return the status code abd the metadata of the response and
//    }

    //final version to test out returning a list of the movie objects instead of strings
    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
        //on terminal type curl -i and the HTTP link, will return the status code abd the metadata of the response and
    }

    //this movie object is used by the controller layer to call its function
    @Autowired
    private MovieService movieService;

    //let java know we can return null if an object id is not correspond to a movie
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        //The @PathVariable annotation is to let the Spring annotation knows that
        //this method parameter should be bound to a URI template variable
        //aka, this variable is part of the http path
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }




}
