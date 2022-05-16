package by.library.mapper;

import by.library.dto.admin.MovieDtoForAdmin;
import by.library.dto.admin.TicketDtoForAdmin;
import by.library.dto.admin.UserDtoForAdmin;
import by.library.model.Movie;
import by.library.model.Ticket;
import by.library.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    @Named(value = "movieDto")
    Movie toMovie(MovieDtoForAdmin movieDto);

    @Named(value = "movieEntity")
    MovieDtoForAdmin toMovieDto(Movie movie);

    @IterableMapping(qualifiedByName = "movieDto")
    List<Movie> mapToMovieList(List<MovieDtoForAdmin> movieDto);

    @IterableMapping(qualifiedByName = "movieEntity")
    List<MovieDtoForAdmin> mapToMovieDtoList(List<Movie> movie);


    @Named(value = "ticketDto")
    Ticket toTicket(TicketDtoForAdmin ticketDto);

    @Named(value = "ticketEntity")
    TicketDtoForAdmin toTicketDto(Ticket ticket);

    @IterableMapping(qualifiedByName = "ticketDto")
    List<Ticket> mapToTicketList(List<TicketDtoForAdmin> ticketDtoList);

    @IterableMapping(qualifiedByName = "ticketEntity")
    List<TicketDtoForAdmin> mapToTicketDtoList(List<Ticket> ticketList);


    @Named(value = "userDto")
    User toUser(UserDtoForAdmin userDto);

    @Named(value = "userEntity")
    UserDtoForAdmin toUserDto(User user);

    @IterableMapping(qualifiedByName = "userDto")
    List<User> mapToUserList(List<UserDtoForAdmin> userDtoList);

    @IterableMapping(qualifiedByName = "userEntity")
    List<UserDtoForAdmin> mapToUserDtoList(List<User> userList);
}