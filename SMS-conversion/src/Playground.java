import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Message;


public class Playground {

	public static void main(String[] args) throws TwilioRestException {
		// define string
		// send it to api
		// ???
		// receive it on the phone
		SMSReceivingService srs = new SMSReceivingService();
		for (Message m : srs.getInboundMessages()) {
			System.out.printf("From: %s\nText: %s\n\n", m.getFrom(), m.getBody());
		}
	}

}
