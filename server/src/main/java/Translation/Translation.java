package Translation;
import java.util.HashMap;

import com.google.api.GoogleAPI;
import com.google.api.GoogleAPIException;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;



public class Translation {
  
	public static String translate(String text, String inputLanguage, String outputLanguage){
	  
		
		GoogleAPI.setHttpReferrer("www.lool.com");

		GoogleAPI.setKey("AIzaSyDZnUPNlvjgAQzLhZzfB396fJCR49bN5F0");
		
		
		String translatedText;
		try {
			translatedText = Translate.DEFAULT.execute(text, getLanguage(inputLanguage), getLanguage(outputLanguage));
		} catch (GoogleAPIException e) {
			translatedText = "An error occured. Please try again";
		}
		
		return translatedText;
	}
	
	public static Language getLanguage(String rawLanguage){
		
		//if (! isAlpha(rawLanguage)){
		//	System.out.println("Invalid language type input.");
		//	return Language.AUTO_DETECT;
		//}
		
		
		HashMap<String , Language> h = new HashMap<String , Language>();
		h.put("ZA", Language.AFRIKAANS);
		h.put("PY", Language.GUARANI);
		h.put("PT", Language.PORTUGUESE);
		//h.put("PK", Language.PASHTO);
		h.put("AutoDetect", Language.AUTO_DETECT);
		h.put("EN", Language.ENGLISH);
		h.put("AR", Language.ARABIC);
		h.put("SW", Language.SWAHILI);
		
		if (h.containsKey(rawLanguage)){
			//System.out.println(rawLanguage);
			return h.get(rawLanguage);
		}
		else {
			//System.out.println(rawLanguage);
			return Language.AUTO_DETECT;
		}
		
		
		
	}
	
  
}