package com.linkeIT.api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.linkeIT.api.entity.RegistroVisitas;

@Repository
public interface RegistroVisitasRepository extends JpaRepository<RegistroVisitas, Long>{

	/**
	 * Recupera un registro de visitas mediante id y DNI
	 * @param idVisita - la id del registro de visitas
	 * @param dni - el dni
	 * @return el registro de visitas
	 */
	@Query("select v from RegistroVisitas v where idVisita=:id and v.dni=:dni")
	public RegistroVisitas findByIdandDni(@Param("id")Long idVisita,@Param("dni") String dni);

	/**
	 * Borra un registro visita anterior a 2 años
	 *
	 * @param fechaBorrado - fecha de borrado
	 * @return the integer
	 */
	@Transactional
	@Modifying
	@Query("delete from RegistroVisitas f where f.fechaEntrada < :fechaBorrado")
	public void borrarFechasEntradaSuperior2y(@Param("fechaBorrado") LocalDateTime fechaBorrado);
	
	/**
	 * Recupera un registro de visitas entre dos fechas de entrada
	 * @param fechaEntradaInicial - la fecha de entrada inicial del periodo
	 * @param fechaEntradaFinal - la fecha de entrada final del periodo
	 * @return el registro de visitas
	 */
	@Query("select v from RegistroVisitas v where fechaentrada between :fechaEntradaInicial and :fechaEntradaFinal")
	public List<RegistroVisitas> findByFechaEntradaBetweenPeriod(@Param("fechaEntradaInicial") LocalDateTime fechaEntradaInicial, @Param("fechaEntradaFinal") LocalDateTime fechaEntradaFinal);
	
}
