package com.cargill.customerfacing.dscportal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import com.cargill.customerfacing.dscportal.domain.CustomerProfile;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.repository.CustomerProfileRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class CustomerProfileService {
	
	private Logger logger = LoggerFactory.getLogger(CustomerProfileService.class);
	
	@Autowired
	private CustomerProfileRepository profileRepository;
	
    @RequestMapping(
            value = "/customerprofileByCustomerId/{customerId}",
            method = RequestMethod.GET)
    public CustomerProfile getCustomerProfileByCustomerid(@PathVariable("customerId") String customerId) {
    	logger.info(":::::::::: getCustomerProfileByID :::::::::::::::");
		return profileRepository.getCustomerProfileByID(customerId);
    }
    @RequestMapping(
            value = "/customerprofile",
            method = RequestMethod.POST,
            consumes = "application/json")
	public void insertCustomerProfile (@RequestBody CustomerProfile profile) {
    	logger.info(":::::::::: insertCustomerProfile :::::::::::::::");
    	profileRepository.insertCustomerProfile(profile);
	}
    @RequestMapping(
            value = "/customerprofile/{customerId}",
            method = RequestMethod.PUT,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void updateCustomerProfile(@PathVariable("customerId") String customerId, @RequestBody CustomerProfile profile) {
    	logger.info(":::::::::: updateCustomerProfile :::::::::::::::");
    	profileRepository.updateCustomerProfile(customerId, profile);
    }
}
