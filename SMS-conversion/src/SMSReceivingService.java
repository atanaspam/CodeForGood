//Install the Java helper library from twilio.com/docs/java/install
import java.util.ArrayList;
import java.util.List;

import com.twilio.sdk.*; 
import com.twilio.sdk.resource.instance.*; 
import com.twilio.sdk.resource.list.*; 

public class SMSReceivingService {
	TwilioRestClient client;
	
	public SMSReceivingService() {
		this.client = new TwilioRestClient(TwilioConstants.ACCOUNT_SID, TwilioConstants.AUTH_TOKEN);
	}

	public List<Message> getInboundMessages() throws TwilioRestException {
		// Build the parameters
		MessageList messages = client.getAccount().getMessages();
		List<Message> l = new ArrayList<Message>();

		// Loop over messages and print out a property for each one.
		for (Message message : messages) {
			if (message.getDirection().equals("inbound")) {
				l.add(message);
			}
		}
		return l;
	}
}