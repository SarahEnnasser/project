package org.proj.service;

import org.proj.entity.Ticket;
import org.proj.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;





public class TicketServiceImpl implements TicketService {
	   @Autowired
	    private TicketRepository ticketRepository;

	    @Override
	    public Iterable<Ticket> listTickets() {
	        return ticketRepository.findAll();
	    }

}
