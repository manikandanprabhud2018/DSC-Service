package com.cargill.customerfacing.dscportal.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.MarketInformation;
@Repository
public class MarketInformationRepository {
	
private Logger logger = LoggerFactory.getLogger(CustomerProfileRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<MarketInformation> getMarketInformationList() {
		logger.info(":::::::::::::::::::::: getMarketInformationList repository ::::::::::::::::::::::::");
		return jdbcTemplate.query(DSCConstands.MRKTINFO_SELECT_ALL,new BeanPropertyRowMapper<MarketInformation>(MarketInformation.class));
	}
	
	public MarketInformation getMarketInformation(final String markId) {
		logger.info(":::::::::::::::::::::: getMarketInformation repository ::::::::::::::::::::::::");
		return (MarketInformation) jdbcTemplate.queryForObject(DSCConstands.MRKTINFO_SELECT_QUERY,new Object[] {markId},new BeanPropertyRowMapper<MarketInformation>(MarketInformation.class));
	}

	public void savetMarketInformation(final MarketInformation information) {
		logger.info(":::::::::::::::::::::: InsertMarketInformation repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.MRKTINFO_INSERT_QUERY,  new Object[] {information.getHeading(),information.getDetails(),information.getMarkId(),information.getStatus(),information.getContractType()});
	}
	
	public void updateMarketInformation (final String markId, final MarketInformation information) {
		logger.info(":::::::::::::::::::::: updateMarketInformation  repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.MRKTINFO_UPDATE_QUERY,  new Object[] {information.getHeading(),information.getDetails(),information.getStatus(),information.getContractType()}, new Object[] {markId});
	}
	public void deleteMarketInformation(final String markId) {
		logger.info(":::::::::::::::::::::: deleteMarketInformation  repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.MRKTINFO_DELETE_MARKETID, new Object[] {markId});
	}
}
