package com.techietipps.itshelpdeskservice.services;

import java.util.List;

import com.techietipps.itshelpdeskservice.dao.TicketDao;
import com.techietipps.itshelpdeskservice.models.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ticketServiceImpl")
public class TicketServiceImpl implements TicketService {

    @Autowired
    @Qualifier("ticketDaoImpl")
    private TicketDao ticketDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Ticket> getTickets() {

        return ticketDao.getTickets();
    }

    @Override
    public Ticket getTicketById(Integer id) {
        return ticketDao.getTicketById(id);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketDao.updateTicket(ticket);

    }

}