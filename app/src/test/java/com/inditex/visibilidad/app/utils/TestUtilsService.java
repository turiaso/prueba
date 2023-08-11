package com.inditex.visibilidad.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.inditex.visibilidad.core.usecase.getvisibilidad.GetVisibilidadResponse;

@Service
public class TestUtilsService {

	@Autowired
	private TestRestTemplate restTemplate;
	
	private String getURL(int port, String path) {
		return "http://localhost:" + port + path;
	}

	public GetVisibilidadResponse getVisibilidad(int port) {
		return restTemplate.exchange(
				getURL(port, String.format("/visibilidad")),
				HttpMethod.GET, null,
				GetVisibilidadResponse.class).getBody();
	}


}