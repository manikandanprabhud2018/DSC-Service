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

import com.cargill.customerfacing.dscportal.domain.Chat;
import com.cargill.customerfacing.dscportal.domain.DSCConstands;
import com.cargill.customerfacing.dscportal.repository.ChatRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/DSCPortal")
public class ChatService {

private Logger logger = LoggerFactory.getLogger(ChatService.class);
	
	@Autowired
	private ChatRepository chatRepository;
	
	@RequestMapping(
            value = "/chatList/{userId}",
            method = RequestMethod.GET,
            produces = DSCConstands.APPLICATION_JSON, consumes=DSCConstands.APPLICATION_JSON)
    public List<Chat> getChatList(@PathVariable("userId") String userId) {
    	logger.info(":::::::::: getChatList :::::::::::::::");
		return chatRepository.getChatList(userId);
    }
	 @RequestMapping(
	            value = "/chat",
	            method = RequestMethod.POST,
	            consumes= "multipart/form-data")
		public void saveChat(@RequestBody Chat chat, @RequestPart("file") MultipartFile multipartFile) {
	    	logger.info(":::::::::: saveChat :::::::::::::::"+multipartFile.getName());
	    	chatRepository.saveChat(chat);
		}
}
