package uk.ac.glasgow.jpmcfg2014.server.controller;

import java.util.List;

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
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import uk.ac.glasgow.jpmcfg2014.server.common.URIConstants;
import uk.ac.glasgow.jpmcfg2014.server.domain.User;
import uk.ac.glasgow.jpmcfg2014.server.services.UserService;

@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	ApplicationContext dataSourceContext = new ClassPathXmlApplicationContext("Beans.xml");
	UserService userService = (UserService) dataSourceContext.getBean("userService");

	@RequestMapping(value = URIConstants.USERS, method = RequestMethod.GET)
	public List<User> getAllUsers() {		
		return userService.listUsers();
	}
	
	@RequestMapping(value = URIConstants.USERS + "/{userId}", method = RequestMethod.GET)
	public User getUserWithId(@PathVariable String userId){
		return userService.get(Integer.parseInt(userId));
	}
	
	@RequestMapping(value = URIConstants.USERS_CREATE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {		
		return userService.create(user.getName());
	}
}
