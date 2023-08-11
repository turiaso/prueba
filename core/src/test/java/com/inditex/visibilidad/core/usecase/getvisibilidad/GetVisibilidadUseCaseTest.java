package com.inditex.visibilidad.core.usecase.getvisibilidad;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = { GetVisibilidadUseCase.class })
public class GetVisibilidadUseCaseTest {

	@MockBean
	GetVisibilidadPort getVisibilidadPort;

	@BeforeEach
	public void beforeEach() {
		
	}

	@Test
	public void getVisibilidadOK() {
		when(getVisibilidadPort.getVisibilidad()).thenReturn(Arrays.asList(0L));
		List<Long> countResponse = getVisibilidadPort.getVisibilidad();
		assertNotNull(countResponse);
	}
	
	@Test
	public void getVisibilidadFail() {
		when(getVisibilidadPort.getVisibilidad()).thenThrow(NotFoundException.class);

		boolean except = false;
		try {
			getVisibilidadPort.getVisibilidad();
		}catch (Throwable e) {
			except = true;
			assertThatExceptionOfType(NotFoundException.class); 
		}
		assertTrue(except);
	}
}