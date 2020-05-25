package org.proj.service;

import java.util.List;

import org.proj.entity.Application;

public interface ApplicationService {
	 List<Application> listApplications();
	    Application findApplication(long id);

}
