package org.proj.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.stream.StreamSupport;

import org.junit.Test;
import org.mockito.Mock;
import org.proj.entity.Application;
import org.proj.repository.ApplicationRepository;
import org.proj.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


public class TzaControllerTest {
	@Autowired
    private TzaController controller;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Mock
    private Model model;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void retrieveApplications() throws Exception {
        String returnValue = controller.retrieveApplications(model);
        assertEquals("applications", returnValue);
    }

    @Test
    public void retrieveApplicationsFromService() throws Exception {
        Iterable<Application> applications = applicationService.listApplications();

        assertNotNull(applications);
        assertEquals(5, StreamSupport.stream(applications.spliterator(), false).count());
    }

    @Test
    public void retrieveApplicationsFromRepo() throws Exception {
        Iterable<Application> applications = applicationRepository.findAll();

        assertNotNull(applications);
        assertEquals(5, StreamSupport.stream(applications.spliterator(), false).count());
    }

}
