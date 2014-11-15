package jpm.codeforgood.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jpm.codeforgood.model.Answer;
import jpm.codeforgood.model.Beacon;
import jpm.codeforgood.model.ChatMessage;
import jpm.codeforgood.model.Messages;
import jpm.codeforgood.rowmapper.ChatMessageRowMapper;
import jpm.codeforgood.twilio.SMSReceivingService;
import jpm.codeforgood.twilio.SMSSendingService;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Message;


@RestController
@RequestMapping(value = { "/api", "/" })
// legacy support
public class ApiController {
	final static Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private static final String GET_PHONE_NUMBER = "SELECT PhoneNo "
			+ "FROM userdetails " + "WHERE lower(Username) = lower(?)";
	
	
	@RequestMapping(value = "/sendsms", method = RequestMethod.GET, params = {"to", "text"})
	public @ResponseBody String getAllUsers(@RequestParam(value = "from") String fromUserName, 
											@RequestParam(value = "to") String toUserName, 
											@RequestParam(value = "text") String text) {
		
		String phoneNo = getPhoneForUsername(toUserName);
		
		SMSSendingService sss;
		try {
			sss = new SMSSendingService();
			return sss.sendMessage("+" + phoneNo, text);
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/receivesms", method = RequestMethod.GET, params = {"name"})
	public @ResponseBody String getAllUsers(@RequestParam(value = "name") String name) {
		SMSReceivingService srs = new SMSReceivingService();
		ArrayList<Message> l = new ArrayList<Message>();
		List<Message> received;
		try {
			received = srs.getInboundMessages();
		} catch (TwilioRestException e) {
			e.printStackTrace();
			return "";
		}
		for (Message m : received) {
			if (m.getDirection().equals("inbound") && m.getFrom().substring(1).equals(getPhoneForUsername(name)))
				l.add(m);
		}
		
		return l.get(0).getBody();
	}
	
	private String getPhoneForUsername(String user) {
		if (user.equals("martin"))
			return "447574155899";
		else if (user.equals("issy"))
			return "447592547625";
		else if (user.equals("anthony"))
			return "447542841422";
		else if (user.equals("atanas"))
			return "447453268653";
		else if (user.equals("sadik"))
			return "447462437621";
		else 
			return "447574155899";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public Answer error(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return new Answer("error", "woops, something went wrong");
	}
}
