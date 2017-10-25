package com.cargill.customerfacing.dscportal.repository;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.AlertInfo;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.Payment;



@Repository
public class NotificationRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(NotificationRepository.class);	
	
	protected static final String INSERT_AlERT = "insert into actual_alert (contract_type, alert_id, user_id, message, web, email, sms)	"
			+ "select sa.contract_type, sa.alert_id, au.user_id, concat(sa.message,?) as message, au.web, au.email, au.sms from setup_alert sa inner join alert_user_mapping au "
			+ "on sa.alert_id=au.alert_id	where au.alert_id = ? and au.contract_type= ? "; 
	
	
    public void setupAlert(AlertInfo alertInfo) {     	
    		String strMessage ="";
    	    logger.info("NotificationRepository Start-> ");
    	    
    	    if (alertInfo!=null && alertInfo.getAlertId() == 100)
    	    	strMessage =alertInfo.getCascId();
    	    if (alertInfo!=null && alertInfo.getAlertId() == 101)
    	    	strMessage =alertInfo.getContractNo() +" on "+ alertInfo.getDate();
    	    if (alertInfo!=null && alertInfo.getAlertId() == 102)
    	    	strMessage=alertInfo.getContractNo();
    	    
    	    logger.info("NotificationRepository strMessage -> "+ strMessage);
    	    jdbcTemplate.update(INSERT_AlERT,new Object[]{strMessage,alertInfo.getAlertId(),alertInfo.getContractType()});
    		logger.info("NotificationRepository End -> ");      
    		
    }
    
    public List<AlertInfo> getAlertList() {
		logger.info("::::::::::::: getAlertList :::::::::::::::::::::::::");
		return jdbcTemplate.query(DSCConstands.ACTUAL_ALERT_SELECT_QUERY, new BeanPropertyRowMapper<AlertInfo>(AlertInfo.class));
	}

 
   }
