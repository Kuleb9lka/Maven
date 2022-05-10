package by.library.service.impl;

import by.library.dto.admin.MovieDtoForAdmin;
import by.library.exception.MovieNotFoundException;
import by.library.mapper.admin.AdminMovieMapper;
import by.library.mapper.list.MovieListMapper;
import by.library.model.Movie;
import by.library.repository.MovieRepository;
import by.library.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public MovieDtoForAdmin get(Long id) {

        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No such movie"));

        return AdminMovieMapper.INSTANCE.toDto(movie);
    }

    @Override
    public List<MovieDtoForAdmin> getAll() {

        return MovieListMapper.INSTANCE.toDtoList(movieRepository.findAll());
    }

    @Override
    public MovieDtoForAdmin create(MovieDtoForAdmin movieDtoForAdmin) {

        Movie movie = AdminMovieMapper.INSTANCE.toEntity(movieDtoForAdmin);

        movieRepository.save(movie);

        return AdminMovieMapper.INSTANCE.toDto(movie);
    }

    @Override
    public MovieDtoForAdmin update(MovieDtoForAdmin movieDtoForAdmin) {

        Movie movie = AdminMovieMapper.INSTANCE.toEntity(movieDtoForAdmin);

        movieRepository.save(movie);

        return AdminMovieMapper.INSTANCE.toDto(movie);
    }

    @Override
    public void delete(Long id) {

        movieRepository.deleteById(id);
    }
}