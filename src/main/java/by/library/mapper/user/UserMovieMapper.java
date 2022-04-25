package by.library.mapper.user;

import by.library.dto.user.UserMovieDto;
import by.library.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMovieMapper {

    UserMovieMapper INSTANCE = Mappers.getMapper(UserMovieMapper.class);

    Movie toEntity(UserMovieDto movieDto);
    UserMovieDto toDto(Movie movie);
}
