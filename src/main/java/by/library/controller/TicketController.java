package by.library.controller;


import by.library.dto.admin.TicketDtoForAdmin;
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

    public List<TicketDtoForAdmin> getAll(){

        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public TicketDtoForAdmin get(@PathVariable Long id){

        return ticketService.get(id);
    }

    @PostMapping
    public TicketDtoForAdmin create(@RequestBody TicketDtoForAdmin ticketDto) {

        return ticketService.create(ticketDto);
    }

    @PutMapping
    public TicketDtoForAdmin update(@RequestBody TicketDtoForAdmin ticketDto){

        return ticketService.update(ticketDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        ticketService.delete(id);
    }
}
