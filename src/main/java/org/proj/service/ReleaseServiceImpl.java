package org.proj.service;

import java.util.List;

import org.proj.entity.Release;
import org.proj.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReleaseServiceImpl implements ReleaseService {
	  @Autowired
	    private ReleaseRepository releaseRepository;

	    @Override
	    public List<Release> listReleases() {
	        return (List<Release>) releaseRepository.findAll();
	    }



}
