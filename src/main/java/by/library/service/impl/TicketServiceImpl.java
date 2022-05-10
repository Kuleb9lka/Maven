package by.library.service.impl;

import by.library.dto.admin.TicketDtoForAdmin;
import by.library.exception.TicketNotFoundException;
import by.library.mapper.admin.AdminTicketMapper;
import by.library.mapper.list.TicketListMapper;
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

    @Override
    public TicketDtoForAdmin get(Long id) {

        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException("No such ticket"));

        return AdminTicketMapper.INSTANCE.toDto(ticket);
    }

    @Override
    public List<TicketDtoForAdmin> getAll() {

        return TicketListMapper.INSTANCE.toDtoList(ticketRepository.findAll());
    }

    @Override
    public TicketDtoForAdmin create(TicketDtoForAdmin ticketDto) {

        Ticket ticket = AdminTicketMapper.INSTANCE.toEntity(ticketDto);

        ticketRepository.save(ticket);

        return AdminTicketMapper.INSTANCE.toDto(ticket);
    }

    @Override
    public TicketDtoForAdmin update(TicketDtoForAdmin ticketDto) {

        Ticket ticket = AdminTicketMapper.INSTANCE.toEntity(ticketDto);

        ticketRepository.save(ticket);

        return AdminTicketMapper.INSTANCE.toDto(ticket);
    }

    @Override
    public void delete(Long id) {

        ticketRepository.deleteById(id);
    }
}
