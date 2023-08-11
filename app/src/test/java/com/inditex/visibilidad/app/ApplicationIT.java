package com.inditex.visibilidad.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.inditex.visibilidad.app.utils.TestUtilsService;
import com.inditex.visibilidad.core.usecase.getvisibilidad.GetVisibilidadResponse;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(classes = { Application.class, TestUtilsService.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationIT {

	@LocalServerPort
	private int port;

	@Autowired
	private TestUtilsService testUtilsService;

	@Test
	public void example1() {
		GetVisibilidadResponse response = testUtilsService.getVisibilidad(port);
		assertNotNull(response);
	}

	
}