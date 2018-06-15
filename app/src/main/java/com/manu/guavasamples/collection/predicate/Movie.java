package com.manu.guavasamples.collection.predicate;

/**
 * Created by manu on 3/27/2018.
 */

public class Movie {

    private String name;
    private Genre genre;
    private double rating;

    public Movie(String name, Genre genre, double rating) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

}
