package com.example.MovieProject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data                   //automatic generate getters and setters from lombok
@AllArgsConstructor     //constructor with all fields
@NoArgsConstructor      //constructor with no fields
public class Movie {
    @Id                 //unique identifier for each of the movie document in the database
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;
    //all reviews related to a movie will be added to this list
    @DocumentReference  //only store id of reviews, and reviews will be a separate collection
    private List<Review> reviewIds;

}
