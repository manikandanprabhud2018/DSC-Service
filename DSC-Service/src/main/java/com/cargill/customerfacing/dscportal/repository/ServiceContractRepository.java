package com.cargill.customerfacing.dscportal.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.ServiceContract;

@Repository
public class ServiceContractRepository {

	private Logger logger = LoggerFactory.getLogger(ServiceContractRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ServiceContract> getServiceContractList() {
		logger.info(":::::::::::::::::::::: getServiceContractList repository ::::::::::::::::::::::::");
		return jdbcTemplate.query(DSCConstands.SERVICECONTRACT_SELECT_ALL,new BeanPropertyRowMapper<ServiceContract>(ServiceContract.class));
	}
	
	public ServiceContract serviceContractById(int cakNo) {
		logger.info(":::::::::::::::::::::: serviceContractById repository ::::::::::::::::::::::::");
		return (ServiceContract) jdbcTemplate.queryForObject(DSCConstands.SERVICECONTRACT_BYID,new Object[] {cakNo},new BeanPropertyRowMapper<ServiceContract>(ServiceContract.class));
	}
	
	public void InsertServiceContract(ServiceContract contract) {
		logger.info(":::::::::::::::::::::: InsertServiceContract repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.SERVICECONTRACT_INSERT_QUERY,  new Object[] {contract.getCakNo(),contract.getCakDate(),contract.getCommodity(),contract.getQuantity(),contract.getReceived(),contract.getBalanceStock(),contract.getContractType(),contract.getCustomerId()});
	}
	
	public void updateServiceContract (int cakNo, ServiceContract contract) {
		logger.info(":::::::::::::::::::::: updateServiceContract  repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.SERVICECONTRACT_UPDATE_QUERY,  new Object[] {contract.getCakDate(),contract.getCommodity(),contract.getQuantity(),contract.getReceived(),contract.getBalanceStock(),contract.getContractType(),contract.getCustomerId()}, new Object[] {cakNo});
	}
}
