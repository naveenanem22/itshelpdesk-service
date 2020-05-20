package com.techietipps.itshelpdeskservice.services;

import java.util.List;

import com.techietipps.itshelpdeskservice.dao.TicketDao;
import com.techietipps.itshelpdeskservice.models.Ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("ticketServiceImpl")
public class TicketServiceImpl implements TicketService, MessageListener {

    @Autowired
    @Qualifier("ticketDaoImpl")
    private TicketDao ticketDao;

    

    private final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

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

    @Override
    public void onMessage(Message message) {
       logger.info("Received message: "+message.toString());

    }

}