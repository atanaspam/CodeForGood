package jpm.codeforgood.twilio;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class SMSSendingService {	
	TwilioRestClient client;

	public SMSSendingService() throws TwilioRestException {
		client = new TwilioRestClient(TwilioConstants.ACCOUNT_SID, TwilioConstants.AUTH_TOKEN);
	}

	
	//return Sid of a message
	public String sendMessage(String to, String text) {
		// Build a filter for the MessageList
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body", text));
		params.add(new BasicNameValuePair("To", to));
		params.add(new BasicNameValuePair("From", TwilioConstants.FROM_NUMBER));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		try {
			Message message = messageFactory.create(params);
			return message.getSid();
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}
		return "";
	}
}