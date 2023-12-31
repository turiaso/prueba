package com.inditex.visibilidad.database.usecase.getvisibilidad;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;

import com.inditex.visibilidad.database.repositories.ProductRepository;
import com.inditex.visibilidad.database.repositories.SizeRepository;
import com.inditex.visibilidad.database.repositories.StockRepository;

@SpringBootTest(classes = {ResourceLoader.class, ProductRepository.class, SizeRepository.class, StockRepository.class, GetVisibilidadAdapter.class})
public class GetVisibilidadAdapterTest {
	
	@Autowired
    private GetVisibilidadAdapter getVisibilidadAdapter;

	@Test
	public void getVisibilidad() {
		List<Long> products = getVisibilidadAdapter.getVisibilidad();		
		List<Long> expectedResult = Arrays.asList(5L, 1L, 3L);
		assertArrayEquals(expectedResult.toArray(), products.toArray());
	}
}
