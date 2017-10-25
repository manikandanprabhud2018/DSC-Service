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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.PickupSchedule;
import com.cargill.customerfacing.dscportal.repository.PickupScheduleRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class PickupScheduleService {

private Logger logger = LoggerFactory.getLogger(PickupScheduleService.class);
	
	@Autowired
	private PickupScheduleRepository pickupScheduleRepository;
	
	@RequestMapping(
            value = "/pickupScheduleList/{cakNo}",
            method = RequestMethod.GET,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
    public List<PickupSchedule> getPickupScheduleList(@PathVariable("cakNo") int cakNo) {
    	logger.info(":::::::::: getPickupScheduleList :::::::::::::::");
		return pickupScheduleRepository.getPickupScheduleList(cakNo);
    }
	 @RequestMapping(
	            value = "/pickupSchedule",
	            method = RequestMethod.POST,
	            consumes= "multipart/form-data")
		public void savePickupSchedule(@RequestBody PickupSchedule pickupSchedule,@RequestPart("file") MultipartFile multipartFile) {
	    	logger.info(":::::::::: savePickupSchedule :::::::::::::::"+multipartFile.getName());
	    	pickupScheduleRepository.savePickupSchedule(pickupSchedule);
		}
}
