package by.library.service.impl;

import by.library.dto.admin.TicketDtoForAdmin;
import by.library.exception.TicketNotFoundException;
import by.library.mapper.AdminMapper;
import by.library.model.Ticket;
import by.library.repository.TicketRepository;
import by.library.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final AdminMapper adminMapper;

    @Override
    public TicketDtoForAdmin get(Long id) {

        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException("No such ticket"));

        return adminMapper.toTicketDto(ticket);
    }

    @Override
    public List<TicketDtoForAdmin> getAll() {

        return adminMapper.mapToTicketDtoList(ticketRepository.findAll());
    }

    @Override
    public TicketDtoForAdmin create(TicketDtoForAdmin ticketDto) {

        Ticket convertTicket = adminMapper.toTicket(ticketDto);

        Ticket ticket = ticketRepository.save(convertTicket);

        return adminMapper.toTicketDto(ticket);
    }

    @Override
    public TicketDtoForAdmin update(TicketDtoForAdmin ticketDto) {

        Ticket convertTicket = adminMapper.toTicket(ticketDto);

        Ticket ticket = ticketRepository.save(convertTicket);

        return adminMapper.toTicketDto(ticket);
    }

    @Override
    public void delete(Long id) {

        ticketRepository.deleteById(id);
    }
}