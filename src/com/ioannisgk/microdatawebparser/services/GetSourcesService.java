package com.ioannisgk.microdatawebparser.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ioannisgk.microdatawebparser.repositories.SourcesDAO;

@Service
public class GetSourcesService {
	
	// Inject the sources dao
	@Autowired
	private SourcesDAO sourcesDAO;
	
	public HashMap getSources() {
		return sourcesDAO.allSources();
	}
}