package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.model.Movie;

import java.util.List;

public interface MovieService {
    Movie searchMovieByTitle(String title);

    List<Movie> searchMovieByAuthorContaining(String author);

    List<Movie> searchMovieByGenre(String genre);

    List<Movie> findAllMovies();
}
