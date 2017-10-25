package com.cargill.customerfacing.dscportal.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.CustomerProfile;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;

@Repository
public class CustomerProfileRepository {
	
	private Logger logger = LoggerFactory.getLogger(CustomerProfileRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public CustomerProfile getCustomerProfileByID(final String customerId) {
		logger.info(":::::::::::::::::::::: getCustomerProfileByID repository ::::::::::::::::::::::::");
		return (CustomerProfile) jdbcTemplate.queryForObject(DSCConstands.CUST_PROFILE_SELECT_QUERY,new Object[] {customerId},new BeanPropertyRowMapper<CustomerProfile>(CustomerProfile.class));
	}

	public void insertCustomerProfile(final CustomerProfile profile) {
		logger.info(":::::::::::::::::::::: insertCustomerProfile repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.CUST_PROFILE_INSERT_QUERY,  new Object[] {profile.getUserId(),profile.getEmail(),profile.getFirstName(),profile.getLastname(),profile.getLanguage(),profile.getCustomerId(),profile.getActiveFlag(),profile.getCargillUser(),"Admin","now()","",""});
	}
	
	public void updateCustomerProfile(final String customerId, final CustomerProfile profile) {
		logger.info(":::::::::::::::::::::: insertCustomerProfile repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.CUST_PROFILE_UPDATE_QUERY,  new Object[] {profile.getUserId(),profile.getEmail(),profile.getFirstName(),profile.getLastname(),profile.getLanguage(),profile.getCustomerId(),profile.getActiveFlag(),profile.getCargillUser(),"Admin","","Admin","now()"}, new Object[] {profile.getUserId()});
	}
}
