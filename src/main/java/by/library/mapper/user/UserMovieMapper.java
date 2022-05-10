package by.library.mapper.user;

import by.library.dto.user.MovieDtoForUser;
import by.library.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMovieMapper {

    UserMovieMapper INSTANCE = Mappers.getMapper(UserMovieMapper.class);

    Movie toEntity(MovieDtoForUser movieDto);
    MovieDtoForUser toDto(Movie movie);
}
