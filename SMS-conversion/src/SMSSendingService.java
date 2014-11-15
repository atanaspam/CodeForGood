import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class SMSSendingService {

	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "ACe161139e98191642bff33abb9cfd27c1";
	public static final String AUTH_TOKEN = "abde7904f981b441ff9a82bec40d684b";
	public static final String FROM_NUMBER = "+441212852754";
	
	TwilioRestClient client;

	public SMSSendingService() throws TwilioRestException {
		client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
	}

	
	//return Sid of a message
	public String sendMessage(String to, String text) {
		// Build a filter for the MessageList
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Body", text));
		params.add(new BasicNameValuePair("To", to));
		params.add(new BasicNameValuePair("From", FROM_NUMBER));

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