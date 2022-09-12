package com.example.movieworkshoptemplate.services;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MovieService {

    public String getFirstMovieFromList() {
        MovieDataRepository movieDataRepository = new MovieDataRepository();
        Movie firstMovie = movieDataRepository.moviesInFile().get(0);
        return firstMovie.toString();

    }

    public String getRandomMovieFromList() {
        MovieDataRepository movieDataRepository = new MovieDataRepository();
        int size = movieDataRepository.moviesInFile().size();
        Random random = new Random();
        Movie randomMovie = movieDataRepository.moviesInFile().get(random.nextInt(size));
        return randomMovie.toString();
    }

    public ArrayList<Movie> getTopTen() {
        ArrayList<Movie> moviesFromList = new MovieDataRepository().moviesInFile();
        Collections.sort(moviesFromList);
        return moviesFromList;
    }
}
