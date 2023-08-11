package com.inditex.visibilidad.rest;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.inditex.visibilidad.core.usecase.getvisibilidad.GetVisibilidadResponse;

@VisibilidadController
public class GetVisibilidadController {
	

    @GetMapping("")
    public ResponseEntity<GetVisibilidadResponse> getVisibiliadd() {
        return new ResponseEntity<>(null, OK);
    }
}
