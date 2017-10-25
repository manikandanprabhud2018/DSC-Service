package com.cargill.customerfacing.dscportal.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.PickupSchedule;

@Repository
public class PickupScheduleRepository {

	private Logger logger = LoggerFactory.getLogger(PickupScheduleRepository.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<PickupSchedule> getPickupScheduleList(int cakNo) {
		logger.info(":::::::::::::::::::::: getPickupScheduleList repository ::::::::::::::::::::::::");
		return jdbcTemplate.query(DSCConstands.PICKUP_SCHEDULE_SELECT_QUERY, new Object[] {cakNo}, new BeanPropertyRowMapper<PickupSchedule>(PickupSchedule.class));
	}
	
	public void savePickupSchedule(PickupSchedule pickupSchedule) {
		logger.info(":::::::::::::::::::::: savePickupSchedule repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.PICKUP_SCHEDULE_INSERT_QUERY,  new Object[] {pickupSchedule.getDate(),pickupSchedule.getPickupId(),pickupSchedule.getDocument(),pickupSchedule.getCakNo(),pickupSchedule.getContractType()});
	
	}
}
