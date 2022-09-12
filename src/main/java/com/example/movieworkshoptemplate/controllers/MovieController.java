package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;
import com.example.movieworkshoptemplate.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MovieController {
    //Controller methods
    @GetMapping("/")
    public String index() {
        return """
                Welcome to the Movie Facts Workshop
                - Type /getFirst in the browser line to get the first movie from the list
                - Type /getRandom in the browser line to get a random movie
                - Type /getTenSortByPopularity in the browser line to the top 10 movies
                - Type /howManyWonAnAward in the browser line to see how many movies have won an award""";
    }

    @GetMapping("/getFirst")
    public String getFirst() {
        return new MovieService().getFirstMovieFromList();
    }

    @GetMapping("/getRandom")
    public String getRandom() {
        return new MovieService().getRandomMovieFromList();
    }

    @GetMapping("/getTenSortByPopularity")
    public ArrayList<Movie> topTen() {
        ArrayList<Movie> topTen = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Movie movie = new MovieService().getTopTen().get(i);
            topTen.add(movie);
        }
        return topTen;
    }

}
