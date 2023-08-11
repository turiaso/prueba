package com.inditex.visibilidad.core.usecase.getvisibilidad;

import java.util.List;

@FunctionalInterface
public interface GetVisibilidadPort {
	List<Long> getVisibilidad();
}
