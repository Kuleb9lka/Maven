package by.library.service;

import by.library.dto.admin.AdminTicketDto;

import by.library.model.Ticket;

import java.util.List;

public interface TicketService {

    AdminTicketDto get(Long id);
    List<AdminTicketDto> getAll();
    AdminTicketDto create(AdminTicketDto adminTicketDto);
    AdminTicketDto update(AdminTicketDto adminTicketDto);
    void delete(Long id);
}
