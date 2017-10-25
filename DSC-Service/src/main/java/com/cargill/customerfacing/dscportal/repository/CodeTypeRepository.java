package com.cargill.customerfacing.dscportal.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.CodeType;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;

@Repository
public class CodeTypeRepository {

private Logger logger = LoggerFactory.getLogger(CodeTypeRepository.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public CodeType getCodeType(String codeId) {
		logger.info(":::::::::::::::::::::: getCodeType repository ::::::::::::::::::::::::");
		return (CodeType) jdbcTemplate.queryForObject(DSCConstands.CODE_TYPE_SELECT_QUERY,new Object[] {codeId},new BeanPropertyRowMapper<CodeType>(CodeType.class));
	}

	public void InsertCodeType(CodeType codeType) {
		logger.info(":::::::::::::::::::::: InsertCodeType repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.CODE_TYPE_INSERT_QUERY,  new Object[] {codeType.getCode(),codeType.getDescription(),codeType.getLanguage(),codeType.getCodeId(),codeType.getGroupId()});
	}
}
