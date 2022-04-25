package by.library.service.impl;

import by.library.dto.admin.AdminTicketDto;
import by.library.mapper.admin.AdminTicketMapper;
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

        return AdminTicketMapper.INSTANCE.toDto(optionalTicket.get());
    }

    @Override
    public List<AdminTicketDto> getAll() {

        List<AdminTicketDto> dtoList = new ArrayList<>();

        for (Ticket ticket : ticketRepository.findAll()) {

            AdminTicketDto ticketDto = AdminTicketMapper.INSTANCE.toDto(ticket);

            dtoList.add(ticketDto);
        }

        return dtoList;
    }

    @Override
    public AdminTicketDto create(AdminTicketDto ticketDto) {

        Ticket ticket = AdminTicketMapper.INSTANCE.toEntity(ticketDto);

        ticketRepository.save(ticket);

        return ticketDto;
    }

    @Override
    public AdminTicketDto update(AdminTicketDto ticketDto) {

        Ticket ticket = AdminTicketMapper.INSTANCE.toEntity(ticketDto);

        ticketRepository.save(ticket);

        return ticketDto;
    }

    @Override
    public void delete(Long id) {

        ticketRepository.deleteById(id);
    }
}
