package com.barclays.LibrarySystemAPI.controller;

import com.barclays.LibrarySystemAPI.model.Movie;
import com.barclays.LibrarySystemAPI.service.MovieService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    MovieService movieService;
    @GetMapping("/movie/title")
    public Movie searchMovieByTitle(@PathParam("title") String title){
        return movieService.searchMovieByTitle(title);
    }

    @GetMapping("/movie/author")
    public List<Movie> searchMovieByAuthorContaining(@PathParam("name")String author){
        return movieService.searchMovieByAuthorContaining(author);
    }

    @GetMapping("/movie/genre")
    public List<Movie> searchMovieByGenre(@PathParam("genre") String genre){
        return movieService.searchMovieByGenre(genre);
    }

    @GetMapping("/movie")
    public List<Movie> findAllMovies(){
        return movieService.findAllMovies();
    }

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
}
