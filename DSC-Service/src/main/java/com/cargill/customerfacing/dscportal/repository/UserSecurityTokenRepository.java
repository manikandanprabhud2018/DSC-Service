package com.cargill.customerfacing.dscportal.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.domain.UserSecurityToken;

@Repository
public class UserSecurityTokenRepository {
	
private Logger logger = LoggerFactory.getLogger(UserSecurityTokenRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public UserSecurityToken getUserToken(String userId) {
		logger.info(":::::::::::::::::::::: getUserToken repository ::::::::::::::::::::::::");
		return (UserSecurityToken) jdbcTemplate.queryForObject(DSCConstands.USERTOKEN_SELECT_QUERY,new Object[] {userId},new BeanPropertyRowMapper<UserSecurityToken>(UserSecurityToken.class));
	}

	public void InsertUserToken(UserSecurityToken userSecurityToken) {
		logger.info(":::::::::::::::::::::: InsertUserToken repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.USERTOKEN_INSERT_QUERY,  new Object[] {userSecurityToken.getUserId(),userSecurityToken.getUserToken(),userSecurityToken.getTokenDesc()});
	}
	

}
