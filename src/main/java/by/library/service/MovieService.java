package by.library.service;

import by.library.dto.admin.MovieDtoForAdmin;

import java.util.List;

public interface MovieService {

    MovieDtoForAdmin get(Long id);
    List<MovieDtoForAdmin> getAll();
    MovieDtoForAdmin create(MovieDtoForAdmin movieDto);
    MovieDtoForAdmin update(MovieDtoForAdmin movieDto);
    void delete(Long id);
}
