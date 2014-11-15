package uk.ac.glasgow.jpmcfg2014.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uk.ac.glasgow.jpmcfg2014.server.common.URIConstants;
import uk.ac.glasgow.jpmcfg2014.server.domain.Conversation;
import uk.ac.glasgow.jpmcfg2014.server.domain.User;
import uk.ac.glasgow.jpmcfg2014.server.domain.UserConversation;
import uk.ac.glasgow.jpmcfg2014.server.services.ConversationService;

@RestController
public class ConversationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ConversationController.class);
	
	ApplicationContext dataSourceContext = new ClassPathXmlApplicationContext("Beans.xml");
	ConversationService conversationService = (ConversationService) dataSourceContext.getBean("conversationService");

	@RequestMapping(value = URIConstants.CONVERSATIONS, method = RequestMethod.GET)
	public Conversation getConversationWithUsers(User user1, User user2) {		
		return conversationService.conversationWithUsers(user1, user2);
	}
	
	@RequestMapping(value = URIConstants.CONVERSATIONS + "/{conversationId}", method = RequestMethod.GET)
	public Conversation getConversationWithId(@PathVariable String conversationId){
		return conversationService.get(Integer.parseInt(conversationId));
	}
	
	@RequestMapping(value = URIConstants.CONVERSATIONS_CREATE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Conversation createConversation(@RequestBody UserConversation userConv) {		
		return conversationService.create(userConv);
	}
}
