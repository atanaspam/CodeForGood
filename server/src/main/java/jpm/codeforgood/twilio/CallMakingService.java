package jpm.codeforgood.twilio;
import java.net.URLEncoder;
import java.util.Map;
import java.util.HashMap;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.factory.CallFactory;
 
public class CallMakingService {
	TwilioRestClient client;
	
	private static final String CALL_RESPONSE_FORMAT = "<Response><Say voice=\"alice\">%s</Say></Response>";
	
	public CallMakingService() {
		this.client = new TwilioRestClient(TwilioConstants.ACCOUNT_SID, TwilioConstants.AUTH_TOKEN);
	}
 
    public String makeCall(String to, String sayText) throws TwilioRestException {
        Account mainAccount = client.getAccount();
        CallFactory callFactory = mainAccount.getCallFactory();
        Map<String, String> callParams = new HashMap<String, String>();
        callParams.put("To", to); // Replace with your phone number
        callParams.put("From", TwilioConstants.FROM_NUMBER); // Replace with a Twilio number
        
        
        String responseURL = String.format(CALL_RESPONSE_FORMAT, sayText);
        responseURL = URLEncoder.encode(responseURL);
        callParams.put("Url", "http://twimlets.com/echo?Twiml=" + responseURL);
        // Make the call
        Call call = callFactory.create(callParams);

        return call.getSid();
    }
}