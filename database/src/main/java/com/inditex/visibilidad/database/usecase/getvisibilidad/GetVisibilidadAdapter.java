package com.inditex.visibilidad.database.usecase.getvisibilidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.visibilidad.core.usecase.getvisibilidad.GetVisibilidadPort;
import com.inditex.visibilidad.database.repositories.ProductRepository;
import com.inditex.visibilidad.database.repositories.SizeRepository;
import com.inditex.visibilidad.database.repositories.StockRepository;

@Service
public class GetVisibilidadAdapter implements GetVisibilidadPort {
	
	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
    private SizeRepository sizeRepository;
    
    @Autowired
    private StockRepository stockRepository;

	@Override
	public List<Long> getVisibilidad() {
		return null;
//		priceRepository.findByBrandProductOnDate(brandId,productId, appDate).stream().map(e -> {
//			return new Visibilidad(e.getBrandId(), e.getStartDate(), e.getEndDate(), e.getVisibilidadList() , e.getProductId(), e.getPriority(), e.getVisibilidad(), e.getCurrency());
//		}).toList();
	}
}
