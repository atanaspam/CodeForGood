import com.twilio.sdk.TwilioRestException;


public class Playground {

	public static void main(String[] args) throws TwilioRestException {
		// define string
		// send it to api
		// ???
		// receive it on the phone
		
		String martin = "+447574155899";
		String izi = "+447592547625";
		String anthony = "+447542841422";
		String atanas = "+447453268653";
		String sadik = "+447462437621";
		String vlad = "+447845478600";

		SMSSendingService sss = new SMSSendingService();
		String text = "This is an awesome message from a culturally-different person in Rwana. Yeeey! It was sent form a Java class.";
		
		sss.sendMessage(vlad, text);		
		sss.sendMessage(izi, text);
		sss.sendMessage(anthony, text);
		sss.sendMessage(atanas, text);
		sss.sendMessage(sadik, text);
	}

}
