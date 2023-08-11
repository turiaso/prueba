package com.inditex.visibilidad.core.usecase.getvisibilidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class GetVisibilidadService implements GetVisibilidadUseCase {
	
	@Autowired
    private GetVisibilidadPort getVisibilidadPort;

    @Override
    public GetVisibilidadResponse getVisibilidad() {
        List<Long> visibles = getVisibilidadPort.getVisibilidad();
        if(CollectionUtils.isEmpty(visibles)) {
        	throw new NotFoundException(String.format("No product find"));
        }else {
        	return new GetVisibilidadResponse(visibles);
        }
    }

}
