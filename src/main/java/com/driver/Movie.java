package com.driver;

public class Movie {
    private String name; // name of movie
    private double imdbRating; //Rating of movie
    private String duration; // time period of movie

    public Movie(String name, double imdbRating, String duration) {
        this.name = name;
        this.imdbRating = imdbRating;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
