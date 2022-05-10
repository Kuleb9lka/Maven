package by.library.mapper.admin;


import by.library.dto.admin.MovieDtoForAdmin;
import by.library.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMovieMapper {

    AdminMovieMapper INSTANCE = Mappers.getMapper(AdminMovieMapper.class);

    Movie toEntity(MovieDtoForAdmin movieDto);
    MovieDtoForAdmin toDto(Movie movie);


}
