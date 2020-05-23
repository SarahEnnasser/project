package org.proj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



import org.proj.entity.Application;
import org.proj.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class ProjectApplication { // spring boot app launch class
	
	private static final Logger log = LoggerFactory.getLogger(ProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		System.out.println("hello");
	}
	@Bean
	public CommandLineRunner demo(ApplicationRepository repository) {
		// CommandLineRunner: command line base application
		return (args) -> {
			//saving new application to database
			repository.save(new Application("Trackzilla","kesha.williams","Application for tracking bugs."));
			repository.save(new Application("Expenses","mary.jones","Application to track expense reports."));
			repository.save(new Application("Notifications","karen.kane","Application to send alerts and notifications to users."));
            
			//fetching all the application objects
			for (Application application : repository.findAll()) {
				//printing it out to the screen
				log.info("The application is: " + application.toString());
			}
		};
	}

}
