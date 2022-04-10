package by.library.service;

import by.library.model.movie.Movie;

import java.util.List;

public interface MovieService {

    Movie get(Long id);
    List<Movie> getAll();
    Movie create(Movie movie);
    Movie update(Movie movie);
    Movie delete(Movie movie);
}
