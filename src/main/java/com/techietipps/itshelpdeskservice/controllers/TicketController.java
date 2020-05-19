package com.techietipps.itshelpdeskservice.controllers;

import java.util.List;

import com.techietipps.itshelpdeskservice.models.Ticket;
import com.techietipps.itshelpdeskservice.services.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    @Qualifier("ticketServiceImpl")
    private TicketService ticketService;

    @GetMapping(path = "/ticket")
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping(path = "/ticket/{id}")
    public Ticket getTicketById(@PathVariable("id") Integer id) {
        return ticketService.getTicketById(id);

    }

    @PutMapping(path = "/ticket/{id}")
    public void updateTicket(@PathVariable("id") Integer id, @RequestBody Ticket ticket) {

        ticketService.updateTicket(ticket);

    }

}