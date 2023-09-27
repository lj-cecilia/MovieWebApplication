package com.example.MovieProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired //only apply to global variable, not local variables
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) { //access the movie by the imdbId and then create new review that associates with this movie
        //in review class first assign the reviewBody, then the noArgs Constructor will take care off the rest
        Review review = new Review(reviewBody);
        reviewRepository.insert(review);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId));
                //.apply(new Update.push("reviewIds").value(review));
        return null;
    }

}
