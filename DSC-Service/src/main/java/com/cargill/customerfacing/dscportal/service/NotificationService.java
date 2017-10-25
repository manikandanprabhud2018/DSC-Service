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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cargill.customerfacing.dscportal.domain.AlertInfo;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.Payment;
import com.cargill.customerfacing.dscportal.repository.NotificationRepository;




@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class NotificationService {

	private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
	@Autowired
    NotificationRepository repository;
	   
    /**
     * @param alertinfo
     */
    @RequestMapping(
            value = "/alert",
            		 method = RequestMethod.POST,
            		  consumes = "application/json")
    public @ResponseBody void getNotificationAlerts(@RequestBody AlertInfo alertinfo){
    	logger.info("getNotificationAlerts Start  *** ");
    	
        repository.setupAlert(alertinfo);
        
        logger.info("getNotificationAlerts End **** ");
    }
    
    
    @RequestMapping(
			value = "/alertList",
			method = RequestMethod.GET,
			produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
	public List<AlertInfo> getAlertList() {
		logger.info(":::::::::: getAlertList :::::::::::::::");
		return repository.getAlertList();
	}


}