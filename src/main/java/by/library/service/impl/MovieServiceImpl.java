package by.library.service.impl;

import by.library.dto.admin.AdminMovieDto;
import by.library.mapper.admin.AdminMovieMapper;
import by.library.model.Movie;
import by.library.repository.MovieRepository;
import by.library.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public AdminMovieDto get(Long id) {

        Optional<Movie> optionalMovie = movieRepository.findById(id);

        return AdminMovieMapper.INSTANCE.toDto(optionalMovie.get());
    }

    @Override
    public List<AdminMovieDto> getAll() {

        List<AdminMovieDto> dtoList = new ArrayList<>();

        for (Movie movie : movieRepository.findAll()) {

            AdminMovieDto movieDto = AdminMovieMapper.INSTANCE.toDto(movie);

            dtoList.add(movieDto);
        }

        return dtoList;
    }

    @Override
    public AdminMovieDto create(AdminMovieDto adminMovieDto) {

        Movie movie = AdminMovieMapper.INSTANCE.toEntity(adminMovieDto);

        movieRepository.save(movie);

        return adminMovieDto;
    }

    @Override
    public AdminMovieDto update(AdminMovieDto adminMovieDto) {

        Movie movie = AdminMovieMapper.INSTANCE.toEntity(adminMovieDto);

        movieRepository.save(movie);

        return adminMovieDto;
    }

    @Override
    public void delete(Long id) {

        movieRepository.deleteById(id);
    }
}