package org.proj.web;

import java.util.List;

import org.proj.service.ApplicationService;
import org.proj.service.ReleaseService;
import org.proj.service.TicketService;
import org.proj.entity.Application;
import org.proj.entity.Release;
import org.proj.entity.Ticket;
import org.proj.exception.ApplicationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



import java.util.List;


@RestController // simplifies creating restful web service
@RequestMapping("/tza") // it maps http request to the correct handler methods in the controller
 // tza is the root of all requests coming into this API
public class TzaController {
	 private ApplicationService applicationService;
	    private TicketService ticketService;
	    private ReleaseService releaseService;

	    @Autowired
	    public void setApplicationService(ApplicationService applicationService) {
	        this.applicationService = applicationService;
	    }

	    @Autowired
	    public void setTicketService(TicketService ticketService) {
	        this.ticketService = ticketService;
	    }

	    @Autowired
	    public void setReleaseService(ReleaseService releaseService) {
	        this.releaseService = releaseService;
	    }
	    
       
	    @GetMapping("/applications")
	    public ResponseEntity<List<Application>> getAllApplications() {
	        List<Application> list = applicationService.listApplications();
	        return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
	    }
        
	    @GetMapping("/tickets")
	    public ResponseEntity<List<Ticket>> getAllTickets() {
	        List<Ticket> list = ticketService.listTickets();
	        return new ResponseEntity<List<Ticket>>(list, HttpStatus.OK);
	    }
 
	    @GetMapping("/releases")
	    public ResponseEntity<List<Release>> getAllReleases() {
	        List<Release> list = releaseService.listReleases();
	        return new ResponseEntity<List<Release>>(list, HttpStatus.OK);
	    }

	    @GetMapping("/application/{id}")
	    public ResponseEntity<Application> getApplication(@PathVariable("id") long id) {
	        try {
	            return new ResponseEntity<Application>(applicationService.findApplication(id), HttpStatus.OK);
	        } catch (ApplicationNotFoundException exception) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application Not Found");
	        }
	    }

}
