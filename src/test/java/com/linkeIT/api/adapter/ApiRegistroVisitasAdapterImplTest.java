package com.linkeIT.api.adapter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.linkeIT.api.manager.RegistroVisitasManager;
import com.linkeIT.api.manager.VisitanteManager;
import com.linkeIT.api.model.ConsultarRegistroVisitaResponse;
import com.linkeIT.api.model.NuevoRegistroVisitaResponse;
import com.linkeIT.api.model.SalidaRegistroVisitaResponse;
import com.linkeIT.api.utils.DtoModelEntityConversor;
import com.linkeIT.api.utils.ModelBuilder;
import com.linkeIT.api.utils.Validator;

@RunWith(MockitoJUnitRunner.class)
public class ApiRegistroVisitasAdapterImplTest {
	
	@Mock
	private DtoModelEntityConversor dtoModelConversor;
	
	@Mock
	private VisitanteManager visitanteManager;
	
	@Mock
	private RegistroVisitasManager registroVisitasManager;
	
	@Mock
	private Validator validator;
	
	@InjectMocks
	private ApiRegistroVisitasAdapterImpl apiRegistroVisitasAdapter;

	private ModelBuilder modelBuilder;

	/**
	 * Configure the tests.
	 */
	@Before
    public void setUp() {
		modelBuilder = new ModelBuilder();
    }
	
	@Test
	public void testDoNuevoRegistroVisitaOperation() {
		NuevoRegistroVisitaResponse result = null;
		buildConfigurationDto(Boolean.TRUE);
		buildConfigurationVisitanteManager(Boolean.TRUE);
		buildConfigurationRegistroVisitasManager(Boolean.TRUE);
		result = apiRegistroVisitasAdapter.doNuevoRegistroVisitaOperation(modelBuilder.buildNuevoRegistroVisitasRequest());
		assertThat(result).isNotNull();
	}
	
	@Test
	public void testDoSalidaRegistroVisitaOperation() {
		SalidaRegistroVisitaResponse result = null;
		buildConfigurationDto(Boolean.TRUE);
		buildConfigurationVisitanteManager(Boolean.TRUE);
		buildConfigurationRegistroVisitasManager(Boolean.TRUE);
		result = apiRegistroVisitasAdapter.doSalidaRegistroVisitaOperation(1L, modelBuilder.buildSalidaRegistroVisitaRequest());
		assertThat(result).isNotNull();
	}

	@Test
	public void testDoConsultaRegistroVisitaOperation() {
		ConsultarRegistroVisitaResponse result = null;
		buildConfigurationDto(Boolean.TRUE);
		buildConfigurationVisitanteManager(Boolean.TRUE);
		buildConfigurationRegistroVisitasManager(Boolean.TRUE);
		result = apiRegistroVisitasAdapter.doConsultaRegistroVisitaOperation(modelBuilder.buildConsultarRegistroVisitaRequest());
		assertThat(result).isNotNull();
	}
	
	private void buildConfigurationDto(Boolean isCorrect) {
		when(dtoModelConversor.nuevoRegistroVisitaRequestToRegistroVisitasDto(any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasDto() : null);
		when(dtoModelConversor.salidaRegistroVisitaRequestToRegistroVisitasDto(any(), any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasDto() : null);
		when(dtoModelConversor.generarRegistroDeVisitasParaConsultarRangoMedianteConsultarRegistroVisitaRequest(any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasDto() : null);
//		when(dtoModelConversor.registroVisitasDtoRegistroVisitasModel(any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasModel() : null);
	}
	private void buildConfigurationVisitanteManager(Boolean isCorrect) {
//		when(visitanteManager.recuperarInfoVisitanteMedianteDNI(any())).thenReturn(isCorrect ? modelBuilder.buildVisitanteDto() : null);
		when(visitanteManager.guardarNuevoVisitante(any())).thenReturn(isCorrect ? modelBuilder.buildVisitanteDto() : null);
//		when(visitanteManager.recuperarInfoVisitanteMedianteDNI(any())).thenReturn(isCorrect ? modelBuilder.buildVisitanteDto() : null);
	}
	private void buildConfigurationRegistroVisitasManager(Boolean isCorrect) {
		when(registroVisitasManager.registrarNuevaVisita(any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasDto() : null);
		when(registroVisitasManager.recuperarRegistroVisita(any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasDto() : null);
		when(registroVisitasManager.guardarRegistroVisitaConFechaSalida(any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasDto() : null);
//		when(registroVisitasManager.recuperarRegistroVisitasEnUnPeriodo(any())).thenReturn(isCorrect ? modelBuilder.buildRegistroVisitasListDto() : null);
	}



}
