package by.library.controller;


import by.library.dto.admin.AdminTicketDto;
import by.library.model.Ticket;
import by.library.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping

    public List<AdminTicketDto> getAll(){

        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public AdminTicketDto get(@PathVariable Long id){

        return ticketService.get(id);
    }

    @PostMapping
    public AdminTicketDto create(@RequestBody AdminTicketDto adminTicketDto) {

        return ticketService.create(adminTicketDto);
    }

    @PutMapping
    public AdminTicketDto update(@RequestBody AdminTicketDto adminTicketDto){

        return ticketService.update(adminTicketDto);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        ticketService.delete(id);
    }
}
