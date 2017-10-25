package com.cargill.customerfacing.dscportal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.MarketInformation;
import com.cargill.customerfacing.dscportal.repository.MarketInformationRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class MarketInformationService {
	
private Logger logger = LoggerFactory.getLogger(MarketInformationService.class);
	
	@Autowired
	private MarketInformationRepository marketInformationRepository;
	
	@RequestMapping(
            value = "/marketInformationList",
            method = RequestMethod.GET,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
    public List<MarketInformation> getMarketInformationList() {
    	logger.info(":::::::::: getMarketInformationList :::::::::::::::");
		return marketInformationRepository.getMarketInformationList();
    }
	
    @RequestMapping(
            value = "/marketInformation",
            method = RequestMethod.GET,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
    public MarketInformation getMarketInformationByMarktId(@RequestParam("markId") String markId) {
    	logger.info(":::::::::: getMarketInformation :::::::::::::::");
		return marketInformationRepository.getMarketInformation(markId);
    }
    @RequestMapping(
            value = "/saveMarketInformation",
            method = RequestMethod.POST,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void savetMarketInformation (@RequestBody MarketInformation information) {
    	logger.info(":::::::::: InsertMarketInformation :::::::::::::::");
    	marketInformationRepository.savetMarketInformation(information);
	}
    @RequestMapping(
            value = "/marketInformation/{markId}",
            method = RequestMethod.PUT,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void updateMarketInformation(@PathVariable("markId") String markId, @RequestBody MarketInformation information) {
    	logger.info(":::::::::: updateMarketInformation :::::::::::::::");
    	marketInformationRepository.updateMarketInformation(markId, information);
    }
    @RequestMapping(
            value = "/marketInformation/{markId}",
            method = RequestMethod.DELETE,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void deleteMarketInformation(@PathVariable("markId") String markId) {
    	logger.info(":::::::::: updateMarketInformation :::::::::::::::");
    	marketInformationRepository.deleteMarketInformation(markId);
    }


}
