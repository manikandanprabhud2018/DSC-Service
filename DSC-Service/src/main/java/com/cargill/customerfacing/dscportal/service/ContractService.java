package com.cargill.customerfacing.dscportal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cargill.customerfacing.dscportal.domain.Contract;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.repository.ContractRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class ContractService {

private Logger logger = LoggerFactory.getLogger(ContractService.class);
	
	@Autowired
	private ContractRepository contractRepository;
	
	@RequestMapping(
            value = "/contractService",
            method = RequestMethod.GET,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
    public Contract getContractByCakNo(@RequestParam("cakNo") int cakNo) {
    	logger.info(":::::::::: getContract :::::::::::::::");
		return contractRepository.getContract(cakNo);
    }
	@RequestMapping(
            value = "/contract",
            method = RequestMethod.POST,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void insertContract (@RequestBody Contract contract) {
    	logger.info(":::::::::: insertContract :::::::::::::::");
    	contractRepository.insertContract(contract);
	}
}
