package com.inditex.visibilidad.database.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.inditex.visibilidad.core.usecase.getvisibilidad.NotFoundException;
import com.inditex.visibilidad.database.domain.StockEntity;

//@Repository
@Component
public class StockRepository {

	@Autowired
	private ResourceLoader resourceLoader;
	
	public StockEntity findBySizeId(Long sizeId){
		try {
			File f = resourceLoader.getResource("classpath:stock.csv").getFile();
			try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			        String[] values =  StringUtils.trimArrayElements(line.split(","));
			        StockEntity e = new StockEntity(Long.valueOf(values[0]), Long.valueOf(values[1]));
			        if(e.getSizeId().equals(sizeId)) return e; 
			    }
			}
			return new StockEntity(sizeId, 0L);
		} catch (Throwable e) {
			throw new NotFoundException(e.getMessage());
		} 
	}	

}
