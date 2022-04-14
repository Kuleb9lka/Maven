package by.library.controller;


import by.library.dto.TicketDto;
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
    public List<Ticket> getAll(){

        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public Ticket get(@PathVariable Long id){

        return ticketService.get(id);
    }

    @PostMapping
    public Ticket create(@RequestBody TicketDto movie) {

        return ticketService.create(movie);
    }

    @PutMapping
    public Ticket update(@RequestBody TicketDto movie){

        return ticketService.update(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        ticketService.delete(id);
    }
}
