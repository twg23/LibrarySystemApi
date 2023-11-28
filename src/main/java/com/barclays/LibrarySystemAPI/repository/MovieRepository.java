package com.barclays.LibrarySystemAPI.repository;

import com.barclays.LibrarySystemAPI.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {


     Movie searchMovieByTitle(String title);

    List<Movie> searchMovieByAuthorContaining(String author);
     List<Movie> searchMovieByGenre(String genre);



}
