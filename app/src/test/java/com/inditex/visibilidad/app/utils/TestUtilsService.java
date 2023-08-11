package com.inditex.visibilidad.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestUtilsService {

	@Autowired
	private TestRestTemplate restTemplate;
	
	private String getURL(int port, String path) {
		return "http://localhost:" + port + path;
	}



}