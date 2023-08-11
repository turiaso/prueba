package com.inditex.visibilidad.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import com.inditex.visibilidad.app.utils.TestUtilsService;

@TestInstance(Lifecycle.PER_CLASS)
@TestPropertySource({ "classpath:application.properties" })
@SpringBootTest(classes = { Application.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationIT {

	@LocalServerPort
	private int port;

	@Autowired
	private TestUtilsService testUtilsService;

	@Test
	public void example1() {
		
	}

	
}