package com.cargill.customerfacing.dscportal.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cargill.customerfacing.dscportal.domain.Chat;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;

@Repository
public class ChatRepository {
	
	private Logger logger = LoggerFactory.getLogger(ChatRepository.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Chat> getChatList(String userId) {
		logger.info(":::::::::::::::::::::: getChatList repository ::::::::::::::::::::::::");
		return jdbcTemplate.query(DSCConstands.CHAT_SELECT_QUERY, new Object[] {userId}, new BeanPropertyRowMapper<Chat>(Chat.class));
	}
	
	public void saveChat(Chat chat) {
		logger.info(":::::::::::::::::::::: saveChat repository ::::::::::::::::::::::::");
		jdbcTemplate.update(DSCConstands.CHAT_INSERT_QUERY,  new Object[] {chat.getUserId(),chat.getCakNo(),chat.getChannelId(),chat.getDocument(),chat.getMessageDetails(),chat.getContractType()});
	
	}

}
