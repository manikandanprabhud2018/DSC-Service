package com.cargill.customerfacing.dscportal.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.Contract;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;

@Repository
public class ContractRepository {

	private Logger logger = LoggerFactory.getLogger(ContractRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Contract getContract(int cakNo) {
		logger.info(":::::::::::::::::::::: getContractRepository repository ::::::::::::::::::::::::");
		return (Contract) jdbcTemplate.queryForObject(DSCConstands.CONTRACT_SELECT_QUERY,new Object[] {cakNo},new BeanPropertyRowMapper<Contract>(Contract.class));
	}

	public void insertContract(Contract contract) {
		logger.info(":::::::::::::::::::::: InsertContractRepository repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.CONTRACT_INSERT_QUERY,  new Object[] {contract.getCakNo(),contract.getApprovedQty(),contract.getContractType(),contract.getStatus(),contract.getCustomerId()});
	}
}
