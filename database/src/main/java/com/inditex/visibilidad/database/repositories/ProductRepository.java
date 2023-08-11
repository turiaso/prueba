package com.inditex.visibilidad.database.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.inditex.visibilidad.core.usecase.getvisibilidad.NotFoundException;
import com.inditex.visibilidad.database.domain.ProductEntity;

//@Repository
@Component
public class ProductRepository {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	public List<ProductEntity> findProductsOrderBySequenceAsc(List<Long> products){
		try {
			File f = resourceLoader.getResource("classpath:product.csv").getFile();
			List<ProductEntity> records = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			        String[] values =  StringUtils.trimArrayElements(line.split(","));
			        ProductEntity e = new ProductEntity(Long.valueOf(values[0]), Long.valueOf(values[1]));
			        if(products.contains(e.getId())) records.add(e);
			    }
			}
			return records.stream().sorted((a, b) -> {
				return a.getSequence().compareTo(b.getSequence());
			}).toList(); 
		} catch (IOException e) {
			throw new NotFoundException(e.getMessage());
		} 
	}

}
