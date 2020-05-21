package com.techietipps.itshelpdeskservice.services;

import java.util.List;

import com.techietipps.itshelpdeskservice.dao.TicketDao;
import com.techietipps.itshelpdeskservice.models.Ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("ticketServiceImpl")
public class TicketServiceImpl implements TicketService/* , MessageListener */ {

    @Autowired
    @Qualifier("ticketDaoImpl")
    private TicketDao ticketDao;

    @Autowired
    private Environment env;

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

    @RabbitListener(queues = "recruitmentQueue")
    public void handleJobCreatedEvent(Message message) {
        logger.info("Received message under handleJobCreatedEvent: " + message.toString());
    }

    /* @Override
    public void onMessage(Message message) {
        logger.info("Received message: " + message.toString());

    } */

}