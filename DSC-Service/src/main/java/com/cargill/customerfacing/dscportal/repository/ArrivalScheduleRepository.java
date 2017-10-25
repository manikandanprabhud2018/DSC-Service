package com.cargill.customerfacing.dscportal.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.cargill.customerfacing.dscportal.domain.ArrivalSchedule;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
/*
 * 
 */
@Repository
public class ArrivalScheduleRepository {
	
	private Logger logger = LoggerFactory.getLogger(ArrivalScheduleRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<ArrivalSchedule> getArrivalSchedule() {
		logger.info(":::::::::: getArrivalSchedule repository:::::::::::::::");
		return jdbcTemplate.query(DSCConstands.ARRIVAL_SCHDL_SELECT_QUERY, new BeanPropertyRowMapper<ArrivalSchedule>(ArrivalSchedule.class));
	}
	public void insertArrivalSchedule (final ArrivalSchedule schedule) {
		logger.info(":::::::::: getArrivalSchedule repository :::::::::::::::");
		jdbcTemplate.update(DSCConstands.ARRIVAL_SCHDL_INSERT_QUERY, new Object[] {schedule.getCargo(),schedule.getVolume(),schedule.getTendered(),schedule.getShipmentPeriod(),schedule.getVesselName(),schedule.getWarehouse(),schedule.getEta(),schedule.getContractType(),schedule.getCakNo()});
	}
	public void updateArrivalSchedule(final String cakNo, final ArrivalSchedule schedule) {
		logger.info(":::::::::: getArrivalSchedule repository:::::::::::::::");
		jdbcTemplate.update(DSCConstands.ARRIVAL_SCHDL_UPDATE_QUERY, new Object[] {schedule.getCargo(),schedule.getVolume(),schedule.getTendered(),schedule.getShipmentPeriod(),schedule.getVesselName(),schedule.getWarehouse(),schedule.getEta(),schedule.getContractType(),schedule.getCakNo()},new Object[] {cakNo});
	}
}
