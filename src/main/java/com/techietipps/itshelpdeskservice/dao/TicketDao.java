package com.techietipps.itshelpdeskservice.dao;

import java.util.List;

import com.techietipps.itshelpdeskservice.models.Ticket;

public interface TicketDao {

    public List<Ticket> getTickets();

    public Ticket getTicketById(Integer id);

    public void updateTicket(Ticket ticket);

}