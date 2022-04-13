package by.library.service;

import by.library.dto.MovieDto;
import by.library.model.Movie;

import java.util.List;

public interface MovieService {

    Movie get(Long id);
    List<Movie> getAll();
    Movie create(MovieDto movie);
    Movie update(MovieDto movie);
    void delete(Long id);
}
