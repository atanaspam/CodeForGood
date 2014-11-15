package jpm.codeforgood.twilio;
import java.util.ArrayList;
import java.util.List;

import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Message;


public class Playground {

	public static void main(String[] args) throws TwilioRestException {
		// define string
		// send it to api
		// ???
		// receive it on the phone
		SMSReceivingService srs = new SMSReceivingService();
		ArrayList<Message> l = new ArrayList<Message>();
		List<Message> received =  srs.getInboundMessages();
		for (Message m : received) {
			if (m.getDirection().equals("inbound") && m.getFrom().substring(1).equals(getPhoneForUsername("martin")))
				l.add(m);
		}
		
		for (Message m : l) {
			if (m.getDirection().equals("inbound") && m.getFrom().substring(1).equals(getPhoneForUsername("vlad")))
				System.out.printf("Text: %s\n", m.getBody());
		}
		
		CallMakingService cms = new CallMakingService();
		// cms.makeCall("+447950188801", "Hello Mr. Alexander. Do you know that Christos'es mustache is beautiful? It is mustache is manly. It is mustache is robust. It is mustache is all-male. It is mustache is brave. It is mustache is macho. It is mustache is manful. It is mustache is adventurous.. That is all.");
	}
	
	private static String getPhoneForUsername(String user) {
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

}
