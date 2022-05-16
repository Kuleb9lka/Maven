package by.library.service.impl;

import by.library.dto.admin.MovieDtoForAdmin;
import by.library.exception.MovieNotFoundException;
import by.library.mapper.AdminMapper;
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

    private final AdminMapper adminMapper;

    @Override
    public MovieDtoForAdmin get(Long id) {

        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("No such movie"));

        return adminMapper.toMovieDto(movie);
    }

    @Override
    public List<MovieDtoForAdmin> getAll() {

        return adminMapper.mapToMovieDtoList(movieRepository.findAll());
    }

    @Override
    public MovieDtoForAdmin create(MovieDtoForAdmin movieDtoForAdmin) {

        Movie convertMovie = adminMapper.toMovie(movieDtoForAdmin);

        Movie movie = movieRepository.save(convertMovie);

        return adminMapper.toMovieDto(movie);
    }

    @Override
    public MovieDtoForAdmin update(MovieDtoForAdmin movieDtoForAdmin) {

        Movie convertMovie = adminMapper.toMovie(movieDtoForAdmin);

        Movie movie = movieRepository.save(convertMovie);

        return adminMapper.toMovieDto(movie);
    }

    @Override
    public void delete(Long id) {

        movieRepository.deleteById(id);
    }
}