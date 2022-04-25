package by.library.controller;


import by.library.dto.admin.AdminTicketDto;
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
    public AdminTicketDto create(@RequestBody AdminTicketDto ticketDto) {

        return ticketService.create(ticketDto);
    }

    @PutMapping
    public AdminTicketDto update(@RequestBody AdminTicketDto ticketDto){

        return ticketService.update(ticketDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        ticketService.delete(id);
    }
}
