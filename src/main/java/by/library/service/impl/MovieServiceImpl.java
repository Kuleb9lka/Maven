package by.library.service.impl;

import by.library.model.movie.Movie;
import by.library.repository.MovieRepository;
import by.library.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAll() {

        return movieRepository.findAll();
    }

    @Override
    public Movie get(Long id) {

        Optional<Movie> optionalMovie = movieRepository.findById(id);

        return optionalMovie.get();
    }

    @Override
    public Movie create(Movie movie) {

        movieRepository.save(movie);

        return movie;
    }

    @Override
    public Movie update(Movie movie) {

        movieRepository.save(movie);

        return movie;
    }

    @Override
    public Movie delete(Movie movie) {

        movieRepository.delete(movie);

        return movie;
    }
}
