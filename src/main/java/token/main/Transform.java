package token.main;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Transforms a text by replacing a set of tokens by
 * pre-defined values
 * 
 * Can add or remove some value, Key and value, for the user with addToken
 * 
 * @author Administrateur
 *
 */

public class Transform {
	
	private static Logger Logger = LoggerFactory.getLogger(Transform.class);
	
	private HashMap<String, String> person = new HashMap<>();
	
	/**
	 * 
	 * @param theme	Name of the key, identifier for the token replacement
	 * @param value	The value for the replacement
	 */
	public void addToken(String theme, String value){
		person.put(theme, value);
	}
	
	/**
	 * 
	 * @param theme	Name of the key, you want to remove from the Hashmap
	 */
	void removeToken(String theme) {
		person.remove(theme);
	}
	
	/**
	 * 
	 * @param input	The input text for the replacement, which include the tokens.
	 * 				Take the token in between brackets {} and replace it with the value, 
	 * 				which corresponds to key of our User Hashmap
	 * 
	 * 				ex: Hello {firstname} ! => Hello person.get("firstname") !
	 * @return 
	 */
	String transformer(String input) {
		
		Pattern p = Pattern.compile("\\{(.+?)\\}");
		Matcher m = p.matcher(input);
		
		StringBuffer sBuffer = new StringBuffer();
		
		while(m.find()) {
			String keyString = (String) (m.group().subSequence(1,( m.group().length()-1)));
			String value = person.get(keyString);
			
			if(value != null) {
				m.appendReplacement(sBuffer, value);
			}
		}
		
		m.appendTail(sBuffer);
		
		Logger.info(sBuffer.toString());
		return sBuffer.toString();
	}
	
}
