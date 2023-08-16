package com.inditex.visibilidad.database.usecase.getvisibilidad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.visibilidad.core.usecase.getvisibilidad.GetVisibilidadPort;
import com.inditex.visibilidad.database.domain.SizeEntity;
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
		
		List<Long> visibleProducts = new ArrayList<>();
		List<Long> distincProducts = sizeRepository.findDistinctProductId();
		for(Long productId : distincProducts) { // Repite N cardinalidad
			int hasStock = 0;
			boolean hasSpecialCondition = false;
			boolean hasSpecialStock = true;
			List<SizeEntity> sizes = sizeRepository.findByProductId(productId);
			for(SizeEntity sizeEntity : sizes) { // Repite M cardinalidad
				hasSpecialCondition = hasSpecialCondition || sizeEntity.getSpecial();
				if(sizeEntity.getBackSoon()) {
					hasStock++;
				}else {
					Long quantity = stockRepository.findBySizeId(sizeEntity.getId()).getQuantity();
					if(quantity > 0) {
						hasStock++;
					}else if (sizeEntity.getSpecial()){						
						hasSpecialStock = false;
					}
				}
			}
			if(!hasSpecialCondition && hasStock > 0 || hasSpecialCondition && hasStock >= 2 && hasSpecialStock) {
				visibleProducts.add(productId);
			}
		}
		return productRepository.findProductsOrderBySequenceAsc(visibleProducts).stream().map(e -> e.getId()).toList();
		//Complejidad O(n·m) = O(n^2)
	}
}
