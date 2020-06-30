package com.linkeIT.api.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.linkeIT.api.model.dto.RegistroVisitasDto;
import com.linkeIT.api.repository.RegistroVisitasRepository;
import com.linkeIT.api.utils.DtoModelEntityConversor;
import com.linkeIT.api.utils.ModelBuilder;

@RunWith(MockitoJUnitRunner.class)
public class RegistroVisitasDaoTest {
	
	private ModelBuilder modelBuilder;
	
	@Mock
	private RegistroVisitasRepository registroVisitasRepository;
	
	@Mock
	private DtoModelEntityConversor dtoModelEntityConveror;
	
	@InjectMocks
	private RegistroVisitasDaoImpl registroVisitasDao;
	/**
	 * Configure the tests.
	 */
	@Before
    public void setUp() {
		modelBuilder = new ModelBuilder();
    }
	
	@Test
	public void guardarRegistroVisitasWithRepoNullAndDtoNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.FALSE);
		buildConfigurationRepositoryDto(Boolean.FALSE);
		result = registroVisitasDao.guardarRegistroVisita(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNull();
	}
	@Test
	public void guardarRegistroVisitasWithRepoNullAndDtoNotNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.FALSE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = registroVisitasDao.guardarRegistroVisita(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNotNull();
	}
	@Test
	public void guardarRegistroVisitasWithRepoNotNullAndDtoNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.FALSE);
		result = registroVisitasDao.guardarRegistroVisita(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNull();
	}
	@Test
	public void guardarRegistroVisitasWithRepoNotNullAndDtoNotNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = registroVisitasDao.guardarRegistroVisita(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNotNull();
	}
	
	@Test
	public void recuperarRegistroVisitaWithRepoNotNullAndDtoNotNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = registroVisitasDao.recuperarRegistroVisita(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNotNull();
	}
	@Test
	public void recuperarRegistroVisitaWithRepoNullAndDtoNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.FALSE);
		buildConfigurationRepositoryDto(Boolean.FALSE);
		result = registroVisitasDao.recuperarRegistroVisita(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNull();
	}
	
	@Test
	public void recuperarRegistroVisitaWithRepoNullAndDtoNotNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.FALSE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = registroVisitasDao.recuperarRegistroVisita(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNull();
	}
	@Test
	public void recuperarRegistroVisitaWithRepoNotNullAndDtoNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.FALSE);
		result = registroVisitasDao.recuperarRegistroVisita(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNull();
	}
	
	@Test
	public void recuperarRegistroVisitasEnUnPeriodoWithRepoNullAndDtoNull() {
		List<RegistroVisitasDto> result = null;
		buildConfigurationRepository(Boolean.FALSE);
		buildConfigurationRepositoryDto(Boolean.FALSE);
		result = registroVisitasDao.recuperarRegistroVisitasEnUnPeriodo(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNull();
	}
	@Test
	public void recuperarRegistroVisitasEnUnPeriodoWithRepoNullAndDtoNotNull() {
		List<RegistroVisitasDto> result = null;
		buildConfigurationRepository(Boolean.FALSE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = registroVisitasDao.recuperarRegistroVisitasEnUnPeriodo(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNull();
	}
	@Test
	public void recuperarRegistroVisitasEnUnPeriodoWithRepoNotNullAndDtoNull() {
		List<RegistroVisitasDto> result = null;
		buildConfigurationRepository(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.FALSE);
		result = registroVisitasDao.recuperarRegistroVisitasEnUnPeriodo(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNotNull();
	}
	@Test
	public void recuperarRegistroVisitasEnUnPeriodoWithRepoNotNullAndDtoNotNull() {
		List<RegistroVisitasDto> result = null;
		buildConfigurationRepository(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = registroVisitasDao.recuperarRegistroVisitasEnUnPeriodo(null);
		assertThat(result).isNotNull();
	}
	
	@Test
	public void guardarRegistroVisitasInputNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = registroVisitasDao.guardarRegistroVisita(null);
		assertThat(result).isNull();
	}
	
	@Test
	public void recuperarRegistroVisitasEnUnPeriodoInputNull() {
		List<RegistroVisitasDto> result = null;
		buildConfigurationRepository(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = registroVisitasDao.recuperarRegistroVisitasEnUnPeriodo(modelBuilder.buildRegistroVisitasDto());
		assertThat(result).isNull();
	}
	
	@Test
	public void recuperarRegistroVisitaInputNull() {
		RegistroVisitasDto result = null;
		buildConfigurationRepository(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = registroVisitasDao.recuperarRegistroVisita(null);
		assertThat(result).isNull();
	}
	
	
	private void buildConfigurationRepository(Boolean isCorrect) {
		when(registroVisitasRepository.findByIdandDni(any(Long.class), any(String.class))).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasEntity() : null);
		when(registroVisitasRepository.findByFechaEntradaBetweenPeriod(any(), any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasEntityList() : null);
	}
	
	private void buildConfigurationRepositoryDto(Boolean isCorrect) {
		when(dtoModelEntityConveror.registroVisitasEntityRegistroVisitasDto(any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasDto() :null);
	}


}
