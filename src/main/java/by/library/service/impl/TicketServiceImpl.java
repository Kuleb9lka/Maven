package by.library.service.impl;


import by.library.dto.admin.AdminTicketDto;
import by.library.model.Ticket;
import by.library.repository.TicketRepository;
import by.library.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public AdminTicketDto get(Long id) {

        Optional<Ticket> optionalTicket = ticketRepository.findById(id);

        AdminTicketDto adminTicketDto = new AdminTicketDto(optionalTicket.get().getId(),
                optionalTicket.get().getUser(), optionalTicket.get().getMovie(), optionalTicket.get().getPlace(),
                optionalTicket.get().getPrice(), optionalTicket.get().isBought());

        return adminTicketDto;
    }

    @Override
    public List<AdminTicketDto> getAll() {

        List<AdminTicketDto> dtoList = new ArrayList<>();

        for (Ticket ticket : ticketRepository.findAll()) {

            AdminTicketDto adminTicketDto = new AdminTicketDto(ticket.getId(), ticket.getUser(),
                    ticket.getMovie(), ticket.getPlace(), ticket.getPrice(), ticket.isBought());

            dtoList.add(adminTicketDto);
        }

        return dtoList;
    }

    @Override
    public AdminTicketDto create(AdminTicketDto adminTicketDto) {

        Ticket ticket = new Ticket(adminTicketDto.getUserId(), adminTicketDto.getMovieId(),
                adminTicketDto.getPlace(), adminTicketDto.getPrice(), adminTicketDto.isBought());

        ticketRepository.save(ticket);

        return adminTicketDto;
    }

    @Override
    public AdminTicketDto update(AdminTicketDto adminTicketDto) {

        Ticket ticket = new Ticket(adminTicketDto.getId(), adminTicketDto.getUserId(), adminTicketDto.getMovieId(),
                adminTicketDto.getPlace(), adminTicketDto.getPrice(), adminTicketDto.isBought());

        ticketRepository.save(ticket);

        return adminTicketDto;
    }

    @Override
    public void delete(Long id) {

        ticketRepository.deleteById(id);
    }
}
