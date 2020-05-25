package org.proj.service;

import java.util.List;
import java.util.Optional;

import org.proj.entity.Application;
import org.proj.exception.ApplicationNotFoundException;
import org.proj.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ApplicationServiceImpl implements ApplicationService {
	 @Autowired
	    private ApplicationRepository applicationRepository;

	    @Override
	    public List<Application> listApplications() {
	        return (List<Application>) applicationRepository.findAll();
	    }

	    @Override
	    public Application findApplication(long id) {
	        Optional<Application> optionalApplication = applicationRepository.findById(id);

	        if(optionalApplication.isPresent())
	            return optionalApplication.get();
	        else
	            throw new ApplicationNotFoundException("Application Not Found");
	    }

}
