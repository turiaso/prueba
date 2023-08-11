package com.inditex.visibilidad.database.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.inditex.visibilidad.core.usecase.getvisibilidad.NotFoundException;
import com.inditex.visibilidad.database.domain.SizeEntity;

//@Repository
@Component
public class SizeRepository {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	public List<Long> findDistinctProductId(){
		try {
			File f = resourceLoader.getResource("classpath:size.csv").getFile();
			Set<Long> records = new HashSet<>();
			try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			        String[] values = StringUtils.trimArrayElements(line.split(","));
			        SizeEntity e = new SizeEntity(Long.valueOf(values[0]), Long.valueOf(values[1]), Boolean.valueOf(values[2]), Boolean.valueOf(values[3]));
			        records.add(e.getProductId());
			    }
			}
			return Arrays.asList(records.toArray(new Long[records.size()])); 
		} catch (IOException e) {
			throw new NotFoundException(e.getMessage());
		} 
	}
	
	public List<SizeEntity> findByProductId(Long productId){
		try {
			File f = resourceLoader.getResource("classpath:size.csv").getFile();
			List<SizeEntity> records = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			        String[] values =  StringUtils.trimArrayElements(line.split(","));
			        SizeEntity e = new SizeEntity(Long.valueOf(values[0]), Long.valueOf(values[1]), Boolean.valueOf(values[2]), Boolean.valueOf(values[3]));
			        if(e.getProductId().equals(productId)) records.add(e);
			    }
			}
			return records; 
		} catch (IOException e) {
			throw new NotFoundException(e.getMessage());
		} 
	}


}
