package com.barclays.LibrarySystemAPI.service;

import com.barclays.LibrarySystemAPI.model.Book;
import com.barclays.LibrarySystemAPI.model.Genre;
import com.barclays.LibrarySystemAPI.model.Movie;
import com.barclays.LibrarySystemAPI.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MovieServiceImplUnitTest {


    Movie movie;

    @Autowired
    MovieServiceImpl movieService;

    @MockBean
    MovieRepository movieRepository;

    List<Movie> movieList;

    @BeforeEach
    void setUp() {

        Genre genre= new Genre(1L,"Fiction");
        Genre genre2= new Genre(2L,"Children");
        Genre genre3= new Genre(3L,"Thriller");

        movieList = new ArrayList<>();
        movieList.add(new Movie(1L, "Inception", "Leonardo DiCaprio, Ellen Page", "Christopher Nolan", "Christopher Nolan","2010-07-16", true , genre,8.8));
        movieList.add(new Movie(2L, "The Shawshank Redemption", "Tim Robbins, Morgan Freeman", "Christopher Nolan", "Frank Darabont","1994-09-23", true , genre2,5));
        movieList.add(new Movie(3L, "Pulp Fiction", "John Travolta, Uma Thurman", "CQuentin Tarantino", "Quentin Tarantino","2008-07-18", true , genre,9.1));
    }

    @Test
   public void searchMovieByTitle() {
        String title = "Inception";
        Movie  expectedMovie = movieList.get(0);
        when(movieRepository.searchMovieByTitle(title)).thenReturn(expectedMovie);
         Movie actualMovie = movieService.searchMovieByTitle("Inception");
         assertEquals(expectedMovie,actualMovie);
    }

    @Test
    void searchMovieByAuthorContaining() {
        String directorName ="Christopher";
        List<Movie> actualMovie = movieList.stream()
                .filter(movie -> "Christopher".equals(movie.getDirector()))
                .collect(Collectors.toList());


        when(movieRepository.searchMovieByAuthorContaining(directorName)).thenReturn(actualMovie);
        List<Movie> expectedMovie= movieService.searchMovieByAuthorContaining(directorName);
        assertEquals(expectedMovie, actualMovie);
    }

    @Test
    void searchMovieByGenre() {
          String genreName ="Fiction";
          List<Movie> actualGenre = movieList.stream()
                  .filter(movie -> "Fiction".equals(movie.getGenre().getBookGenre()))
                  .collect(Collectors.toList());


          when(movieRepository.searchMovieByGenre(genreName)).thenReturn(actualGenre );
       List<Movie> expectedGenre= movieService.searchMovieByGenre(genreName);
          assertEquals(actualGenre, expectedGenre);
    }
    @Test
    void findAllMovies() {

       List<Movie> actualMovieSize = movieList;

       when(movieRepository.findAll()).thenReturn(actualMovieSize);

       List<Movie>  expectedMovieSize = movieService.findAllMovies();

       assertEquals(actualMovieSize, expectedMovieSize);




        
    }
}