package com.inditex.visibilidad.rest;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.inditex.visibilidad.core.usecase.getvisibilidad.GetVisibilidadResponse;
import com.inditex.visibilidad.core.usecase.getvisibilidad.GetVisibilidadUseCase;

@VisibilidadController
public class GetVisibilidadController {
	
	@Autowired
	private GetVisibilidadUseCase getVisibilidadUseCase;

    @GetMapping("")
    public ResponseEntity<GetVisibilidadResponse> getVisibiliadd() {
        return new ResponseEntity<>(getVisibilidadUseCase.getVisibilidad(), OK);
    }
}
