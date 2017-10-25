package com.cargill.customerfacing.dscportal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.ServiceContract;
import com.cargill.customerfacing.dscportal.repository.ServiceContractRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class ServiceContractService {
	
private Logger logger = LoggerFactory.getLogger(ServiceContractService.class);
	
	@Autowired
	private ServiceContractRepository serviceContractRepository;
	
	@RequestMapping(
            value = "/serviceContractList",
            method = RequestMethod.GET,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
    public List<ServiceContract> getServiceContractList() {
    	logger.info(":::::::::: getServiceContractList :::::::::::::::");
		return serviceContractRepository.getServiceContractList();
    }
	
    @RequestMapping(
            value = "/serviceContractByCakNO",
            method = RequestMethod.GET,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
    public ServiceContract serviceContractById(@RequestParam("cakNo") int cakNo) {
    	logger.info(":::::::::: serviceContractById :::::::::::::::");
		return serviceContractRepository.serviceContractById(cakNo);
    }
    @RequestMapping(
            value = "/serviceContract",
            method = RequestMethod.POST,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void InsertServiceContract (@RequestBody ServiceContract contract) {
    	logger.info(":::::::::: InsertServiceContract :::::::::::::::");
    	serviceContractRepository.InsertServiceContract(contract);
	}
    @RequestMapping(
            value = "/serviceContract/{cakNo}",
            method = RequestMethod.PUT,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void updateServiceContract(@RequestParam("cakNo") int cakNo, @RequestBody ServiceContract contract) {
    	logger.info(":::::::::: updateServiceContract :::::::::::::::");
    	serviceContractRepository.updateServiceContract(cakNo, contract);
    }

}
