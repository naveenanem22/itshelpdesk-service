package com.techietipps.itshelpdeskservice.dao;

import java.util.ArrayList;
import java.util.List;

import com.techietipps.itshelpdeskservice.models.Ticket;

import org.springframework.stereotype.Repository;

@Repository("ticketDaoImpl")
public class TicketDaoImpl implements TicketDao {

    @Override
    public List<Ticket> getTickets() {
        Ticket ticket1 = new Ticket();
        ticket1.setDescription("Mouse not working.");
        ticket1.setSubject("Issue with mouse");
        ticket1.setId(123456);

        Ticket ticket2 = new Ticket();
        ticket2.setDescription("Keyboard not working.");
        ticket2.setSubject("Issue with Keyboard");
        ticket2.setId(123457);

        Ticket ticket3 = new Ticket();
        ticket3.setDescription("Laptop not working.");
        ticket3.setSubject("Issue with Laptop");
        ticket3.setId(123458);

        List<Ticket> ticketList = new ArrayList<Ticket>();
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);

        return ticketList;
    }

    @Override
    public Ticket getTicketById(Integer id) {

        Ticket ticket1 = new Ticket();
        ticket1.setDescription("Mouse not working.");
        ticket1.setSubject("Issue with mouse");
        ticket1.setId(123456);
        
        return ticket1;
    }

    @Override
    public void updateTicket(Ticket ticket) {
        

    }

}