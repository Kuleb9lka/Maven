package by.library.service.impl;


import by.library.dto.TicketDto;
import by.library.model.Ticket;
import by.library.repository.TicketRepository;
import by.library.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket get(Long id) {

        Optional<Ticket> optionalTicket = ticketRepository.findById(id);

        return optionalTicket.get();
    }

    @Override
    public List<Ticket> getAll() {

        return ticketRepository.findAll();
    }

    @Override
    public Ticket create(TicketDto ticketDto) {

        Ticket ticket = new Ticket(ticketDto.getUserId(), ticketDto.getMovieId(),
                ticketDto.getPlace(), ticketDto.getPrice(), ticketDto.isBought());

        ticketRepository.save(ticket);

        return ticket;
    }

    @Override
    public Ticket update(TicketDto ticketDto) {

        Ticket ticket = new Ticket(ticketDto.getId(), ticketDto.getUserId(), ticketDto.getMovieId(),
                ticketDto.getPlace(), ticketDto.getPrice(), ticketDto.isBought());

        ticketRepository.save(ticket);

        return ticket;
    }

    @Override
    public void delete(Long id) {

        ticketRepository.deleteById(id);
    }
}
