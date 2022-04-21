package by.library.service;

import by.library.dto.admin.AdminMovieDto;
import by.library.dto.admin.AdminTicketDto;
import by.library.model.Movie;

import java.util.List;

public interface MovieService {

    AdminMovieDto get(Long id);
    List<AdminMovieDto> getAll();
    AdminMovieDto create(AdminMovieDto movieDto);
    AdminMovieDto update(AdminMovieDto movieDto);
    void delete(Long id);
}
