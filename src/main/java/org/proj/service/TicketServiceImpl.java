package org.proj.service;

import java.util.List;

import org.proj.entity.Ticket;
import org.proj.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class TicketServiceImpl implements TicketService {
	   @Autowired
	    private TicketRepository ticketRepository;

	    @Override
	    public List<Ticket> listTickets() {
	        return (List<Ticket>) ticketRepository.findAll();
	    }
}
