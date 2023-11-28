package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.model.Movie;
import com.barclays.LibrarySystemAPI.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    MovieRepository movieRepository;

    @Override
    public Movie searchMovieByTitle(String title){
       return movieRepository.searchMovieByTitle(title);
    }

    @Override
    public List<Movie> searchMovieByAuthorContaining(String author){
        return movieRepository.searchMovieByAuthorContaining(author);
    }

    @Override
    public List<Movie> searchMovieByGenre(String genre){

        return  movieRepository.searchMovieByGenre(genre);


    }

    @Override
    public List<Movie> findAllMovies(){
        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> moviesIts = movieRepository.findAll();
        moviesIts.forEach(movies::add);

        return movies;
    }

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

}
