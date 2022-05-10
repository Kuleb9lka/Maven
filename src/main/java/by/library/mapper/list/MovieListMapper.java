package by.library.mapper.list;

import by.library.dto.admin.MovieDtoForAdmin;
import by.library.model.Movie;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface MovieListMapper {

    MovieListMapper INSTANCE = Mappers.getMapper(MovieListMapper.class);

    List<Movie> toEntityList(List<MovieDtoForAdmin> movieDtoList);
    List<MovieDtoForAdmin> toDtoList(List<Movie> movieList);
}