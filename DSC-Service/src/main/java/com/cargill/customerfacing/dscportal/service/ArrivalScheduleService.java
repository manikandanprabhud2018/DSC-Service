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
import org.springframework.web.bind.annotation.RestController;
import com.cargill.customerfacing.dscportal.domain.ArrivalSchedule;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.repository.ArrivalScheduleRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class ArrivalScheduleService {
	
	private Logger logger = LoggerFactory.getLogger(ArrivalScheduleService.class);
	
	@Autowired
	private ArrivalScheduleRepository scheduleRepository; 
	
	@RequestMapping(
            value = "/arrivalScheduleList",
            method = RequestMethod.GET,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
    public List<ArrivalSchedule> getArrivalSchedule() {
    	logger.info(":::::::::: getArrivalSchedule :::::::::::::::");
		return scheduleRepository.getArrivalSchedule();
    }
    @RequestMapping(
            value = "/arrivalSchedule",
            method = RequestMethod.POST,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void insertArrivalSchedule (@RequestBody ArrivalSchedule schedule) {
    	logger.info(":::::::::: insertArrivalSchedule :::::::::::::::");
    	scheduleRepository.insertArrivalSchedule(schedule);
	}
    @RequestMapping(
            value = "/arrivalSchedule/{cakNo}",
            method = RequestMethod.PUT,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public void updateArrivalSchedule(@PathVariable("cakNo") String cakNo, @RequestBody ArrivalSchedule schedule) {
    	logger.info(":::::::::: updateArrivalSchedule :::::::::::::::");
    	scheduleRepository.updateArrivalSchedule(cakNo, schedule);
    }
}
