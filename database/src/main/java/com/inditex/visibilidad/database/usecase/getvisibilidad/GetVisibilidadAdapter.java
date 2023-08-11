package com.inditex.visibilidad.database.usecase.getvisibilidad;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inditex.visibilidad.core.usecase.getvisibilidad.GetVisibilidadPort;

@Service
public class GetVisibilidadAdapter implements GetVisibilidadPort {
	
//	@Autowired
//    private VisibilidadRepository priceRepository;

	@Override
	public List<Long> getVisibilidad() {
		return null;
//		priceRepository.findByBrandProductOnDate(brandId,productId, appDate).stream().map(e -> {
//			return new Visibilidad(e.getBrandId(), e.getStartDate(), e.getEndDate(), e.getVisibilidadList() , e.getProductId(), e.getPriority(), e.getVisibilidad(), e.getCurrency());
//		}).toList();
	}
}
