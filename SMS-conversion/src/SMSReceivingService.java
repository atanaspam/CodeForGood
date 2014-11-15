//Install the Java helper library from twilio.com/docs/java/install
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.*; 
import com.twilio.sdk.resource.instance.*; 
import com.twilio.sdk.resource.list.*; 

public class SMSReceivingService {

	public static void main(String[] args) throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(
				TwilioConstants.ACCOUNT_SID, TwilioConstants.AUTH_TOKEN);

		// Build the parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Direction", "inbound"));
		MessageList messages = client.getAccount().getMessages((Map<String, String>) params);

		// Loop over messages and print out a property for each one.
		for (Message message : messages) {
			if (message.getDirection().equals("inbound")) {
				System.out.printf("Sid: '%s'\nDirection: '%s'\nFrom: '%s'\nContent: '%s'\n\n",
								message.getSid(), message.getDirection(),
								message.getFrom(), message.getBody());
			}
		}

	}
}