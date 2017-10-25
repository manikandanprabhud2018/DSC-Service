package com.cargill.customerfacing.dscportal.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.Status;

@Repository
public class StatusRepository {

private Logger logger = LoggerFactory.getLogger(StatusRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Status getStatus(String status_id) {
		logger.info(":::::::::::::::::::::: getStatus repository ::::::::::::::::::::::::");
		return (Status) jdbcTemplate.queryForObject(DSCConstands.STATUS_SELECT_QUERY,new Object[] {status_id},new BeanPropertyRowMapper<Status>(Status.class));
	}

	public void InsertStatus(Status status) {
		logger.info(":::::::::::::::::::::: InsertStatus repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.STATUS_INSERT_QUERY,  new Object[] {status.getStatusId(),status.getStatusType(),status.getDescription()});
	}
}
