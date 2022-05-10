package by.library.service;

import by.library.dto.admin.TicketDtoForAdmin;

import java.util.List;

public interface TicketService {

    TicketDtoForAdmin get(Long id);
    List<TicketDtoForAdmin> getAll();
    TicketDtoForAdmin create(TicketDtoForAdmin ticketDtoForAdmin);
    TicketDtoForAdmin update(TicketDtoForAdmin ticketDtoForAdmin);
    void delete(Long id);
}
