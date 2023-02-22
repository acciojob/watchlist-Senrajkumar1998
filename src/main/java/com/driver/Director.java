package com.driver;

public class Director {
    private String name;//director name
    private int numberOfMovie; //no. of movie directed oby directed
    private double imdbRating; // director rating
    public Director() {

    }


    public Director(String name, int numberOfMovie, double imdbRating) {
        this.name = name;
        this.numberOfMovie = numberOfMovie;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovie() {
        return numberOfMovie;
    }

    public void setNumberOfMovie(int numberOfMovie) {
        this.numberOfMovie = numberOfMovie;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
