package by.library.service;

import by.library.dto.MovieDto;
import by.library.dto.TicketDto;
import by.library.model.Movie;
import by.library.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket get(Long id);
    List<Ticket> getAll();
    Ticket create(TicketDto ticketDto);
    Ticket update(TicketDto ticketDto);
    void delete(Long id);
}
