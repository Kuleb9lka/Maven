package by.library.service.impl;

import by.library.dto.MovieDto;
import by.library.model.movie.Movie;
import by.library.repository.MovieRepository;
import by.library.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Movie create(MovieDto movie) {

        Movie movie1 = new Movie(movie.getName(), movie.getDateTime());

        movieRepository.save(movie1);

        return movie1;
    }

    @Override
    public Movie update(MovieDto movie) {

        Movie movie1 = new Movie(movie.getId(), movie.getName(), movie.getDateTime());

        movieRepository.save(movie1);

        return movie1;
    }

    @Override
    public void delete(Long id) {

        movieRepository.deleteById(id);
    }
}