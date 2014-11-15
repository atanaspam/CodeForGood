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
		CallMakingService cms = new CallMakingService();
		cms.makeCall("+447950188801", "Hello Mr. Alexander. Do you know that Christos'es mustache is beautiful? It is mustache is manly. It is mustache is robust. It is mustache is all-male. It is mustache is brave. It is mustache is macho. It is mustache is manful. It is mustache is adventurous.. That is all.");
	}

}
