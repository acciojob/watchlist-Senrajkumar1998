package com.driver;

import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
@Repository
public class MovieRepository {
   private HashMap<String,Movie> movieHashMap; //movie name, movie obj.
   private HashMap<String,Director> directorHashMap; //director name,director obj.
   private HashMap<String, List<String>>directorMovieHashMap; //director name,/list of all movie directed by director

    public MovieRepository() {
        this.movieHashMap=new HashMap<String,Movie>();
        this.directorHashMap=new HashMap<String,Director>();
        this.directorMovieHashMap=new HashMap<String,List<String>>();
    }

    public void saveMovie(Movie movie){
        movieHashMap.put(movie.getName(),movie);
    }
    public void saveDirector(Director director){
        directorHashMap.put(director.getName(),director);
    }
    public void saveMovieDirectorPair(String director,String movie){
        if(movieHashMap.containsKey(movie) && directorHashMap.containsKey(director)){
            List<String>currentMovies= new ArrayList<>();
            if(directorMovieHashMap.containsKey(director)) currentMovies=directorMovieHashMap.get(director);
            currentMovies.add(movie);
            directorMovieHashMap.put(director,currentMovies);
        }
    }
    public Movie findMovie(String movie){
        return movieHashMap.get(movie);
    }

    public Director findDirector(String director){
        return directorHashMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieHashMap.containsKey(director)) moviesList = directorMovieHashMap.get(director);
        return moviesList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieHashMap.keySet());
    }

    public void deleteDirector(String director){
        List<String> movies = new ArrayList<String>();
        if(directorMovieHashMap.containsKey(director)){
            movies = directorMovieHashMap.get(director);
            for(String movie: movies){
                if(movieHashMap.containsKey(movie)){
                    movieHashMap.remove(movie);
                }
            }

            directorMovieHashMap.remove(director);
        }

        if(directorHashMap.containsKey(director)){
            directorHashMap.remove(director);
        }
    }

    public void deleteAllDirector(){
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director: directorMovieHashMap.keySet()){
            for(String movie: directorMovieHashMap.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieHashMap.containsKey(movie)){
                movieHashMap.remove(movie);
            }
        }
    }

}
