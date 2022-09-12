package com.example.movieworkshoptemplate.repositories;

import com.example.movieworkshoptemplate.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MovieDataRepository {

    public ArrayList<Movie> moviesInFile(){
        try {
            ArrayList<Movie> movies = new ArrayList<>();
            Scanner fileScanner = new Scanner(new File("resources/imdb-data.csv"));
            while (fileScanner.hasNextLine()) {
                Scanner in = new Scanner(fileScanner.nextLine()).useDelimiter(";").useLocale(Locale.ENGLISH);
                int year = in.nextInt();
                int length = in.nextInt();
                String title = in.next();
                String subject = in.next();
                int popularity = in.nextInt();
                String awards = in.next();
                Movie newMovie = new Movie(year, length, title, subject, popularity, awards);
                movies.add(newMovie);
            }
            return movies;
        } catch (FileNotFoundException e) {
            return null;
        }

    }

}
