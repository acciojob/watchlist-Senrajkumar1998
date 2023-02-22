package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        MovieService.addMovie(movie);
        return new ResponseEntity<>("New Movie Added Successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        MovieService.addDirector(director);
        return new ResponseEntity<>("New Director Added Successfully", HttpStatus.CREATED);
    }
    @PutMapping("/add_movie_director_pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam ("movie")String movie,@RequestParam ("director")String director){
        MovieService.createMovieDirectorPair(director,movie);
        return new ResponseEntity<>("New Movie-Director pair added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie=movieService.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = movieService.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director + " removed successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
    }


}
