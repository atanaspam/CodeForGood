import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class MSTranslate {
	
	public static void main(String[] args) throws Exception {
		// Set your Windows Azure Marketplace client info - See
		// http://msdn.microsoft.com/en-us/library/hh454950.aspx
		Translate.setClientId("jpm-cfg-2014");
		Translate.setClientSecret("Hf0HvcpC4/J224zbo0oZZv11tGQ8J27HibFdPzwTyt0=");

		String translatedText = Translate.execute("Bonjour le monde", Language.FRENCH, Language.URDU);

		System.out.println(translatedText);
	}
}