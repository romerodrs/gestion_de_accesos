package com.linkeIT.api.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.linkeIT.api.model.dto.VisitanteDto;
import com.linkeIT.api.repository.VisitanteRepository;
import com.linkeIT.api.utils.DtoModelEntityConversor;
import com.linkeIT.api.utils.ModelBuilder;

@RunWith(MockitoJUnitRunner.class)
public class VisitanteDaoTest {

	private ModelBuilder modelBuilder;
	
	@Mock
	private VisitanteRepository visitanteRepository;
	
	@Mock
	private DtoModelEntityConversor dtoModelEntityConveror;
	
	@InjectMocks
	private VisitanteDaoImpl visitanteDao;
	
	/**
	 * Configure the tests.
	 */
	@Before
    public void setUp() {
		modelBuilder = new ModelBuilder();
    }
	
	@Test
	public void recuperarInfoVisitanteMedianteDniInputNull() {
		VisitanteDto result = null;
		buildConfigurationRepositoryDto(Boolean.TRUE);
		buildConfigurationDao(Boolean.TRUE);
		result = visitanteDao.recuperarInfoVisitanteMedianteDNI(null);
		assertThat(result).isNull();
	}

	@Test
	public void recuperarInfoVisitanteMedianteDniRepoNotNullDaoNotNull() {
		VisitanteDto result = null;
		buildConfigurationRepositoryDto(Boolean.TRUE);
		buildConfigurationDao(Boolean.TRUE);
		result = visitanteDao.recuperarInfoVisitanteMedianteDNI("00000000T");
		assertThat(result).isNotNull();
	}
	@Test
	public void recuperarInfoVisitanteMedianteDniRepoNullDaoNotNull() {
		VisitanteDto result = null;
		buildConfigurationRepositoryDto(Boolean.FALSE);
		buildConfigurationDao(Boolean.TRUE);
		result = visitanteDao.recuperarInfoVisitanteMedianteDNI("00000000T");
		assertThat(result).isNull();
	}
	@Test
	public void recuperarInfoVisitanteMedianteDniRepoNotNullDaoNull() {
		VisitanteDto result = null;
		buildConfigurationRepositoryDto(Boolean.TRUE);
		buildConfigurationDao(Boolean.FALSE);
		result = visitanteDao.recuperarInfoVisitanteMedianteDNI("00000000T");
		assertThat(result).isNull();
	}
	@Test
	public void recuperarInfoVisitanteMedianteDniRepoNullDaoNull() {
		VisitanteDto result = null;
		buildConfigurationRepositoryDto(Boolean.FALSE);
		buildConfigurationDao(Boolean.FALSE);
		result = visitanteDao.recuperarInfoVisitanteMedianteDNI("00000000T");
		assertThat(result).isNull();
	}

	@Test
	public void guardarNuevoVisitanteWithRepoNotNullAndDaoNotNullInputNull() {
		VisitanteDto result = null;
		buildConfigurationDao(Boolean.TRUE);
		buildConfigurationRepositoryDto(Boolean.TRUE);
		result = visitanteDao.guardarNuevoVisitante(null);
		assertThat(result).isNotNull();
	}
	
	@Test
	public void guardarNuevoVisitanteWithRepoNotNullAndDaoNotNull() {
		VisitanteDto result = null;
		buildConfigurationRepositoryDto(Boolean.TRUE);
		buildConfigurationDao(Boolean.TRUE);
		result = visitanteDao.guardarNuevoVisitante(modelBuilder.buildVisitanteDto());
		assertThat(result).isNotNull();
	}
	@Test
	public void guardarNuevoVisitanteWithRepoNotNullAndDaoNull() {
		VisitanteDto result = null;
		buildConfigurationRepositoryDto(Boolean.TRUE);
		buildConfigurationDao(Boolean.FALSE);
		result = visitanteDao.guardarNuevoVisitante(modelBuilder.buildVisitanteDto());
		assertThat(result).isNull();
	}
	@Test
	public void guardarNuevoVisitanteWithRepoNullAndDaoNotNull() {
		VisitanteDto result = null;
		buildConfigurationRepositoryDto(Boolean.FALSE);
		buildConfigurationDao(Boolean.TRUE);
		result = visitanteDao.guardarNuevoVisitante(modelBuilder.buildVisitanteDto());
		assertThat(result).isNull();
	}
	@Test
	public void guardarNuevoVisitanteWithRepoNullAndDaoNull() {
		VisitanteDto result = null;
		buildConfigurationRepositoryDto(Boolean.FALSE);
		buildConfigurationDao(Boolean.FALSE);
		result = visitanteDao.guardarNuevoVisitante(modelBuilder.buildVisitanteDto());
		assertThat(result).isNull();
	}
	private void buildConfigurationDao(Boolean isCorrect) {
		when(visitanteRepository.recuperaDatosVisitanteRegistradoMedianteDNI(any(String.class))).thenReturn(isCorrect ? modelBuilder.buildVisitanteEntity() : null);
		when(visitanteRepository.save(any(com.linkeIT.api.entity.Visitante.class))).thenReturn(isCorrect ? modelBuilder.buildVisitanteEntity() : null);
	}
	private void buildConfigurationRepositoryDto(Boolean isCorrect) {
		when(dtoModelEntityConveror.visitanteDtoAVisitanteEntity(any())).thenReturn(isCorrect ? modelBuilder.buildVisitanteEntity() : null);
		when(dtoModelEntityConveror.visitanteEntityAVisitanteDto(any())).thenReturn(isCorrect ? modelBuilder.buildVisitanteDto() : null);
	}

}
