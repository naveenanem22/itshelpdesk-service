package com.techietipps.itshelpdeskservice.services;

import java.util.List;

import com.techietipps.itshelpdeskservice.models.Ticket;

public interface TicketService {
    public List<Ticket> getTickets();

    public Ticket getTicketById(Integer id);

    public void updateTicket(Ticket ticket);

}