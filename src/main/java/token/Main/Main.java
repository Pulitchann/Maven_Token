package token.Main;
/**
 * 
 * @author Administrateur
 *
 */
public class Main {
/**
 * 
 * @param args	OK
 */
	
	public static void main(String[] args) {
		/**
		 * OK
		 */
		Transform georgeTransformer = new Transform();
		Transform erikaMault = new Transform();
		
		georgeTransformer.addToken("abbr", "M");
		georgeTransformer.addToken("name", "Transformateur");
		georgeTransformer.addToken("firstname", "Georges");
		georgeTransformer.addToken("ville", "Lille");
		georgeTransformer.addToken("address", "18, rue des Lilas");
		georgeTransformer.addToken("postalCode", "59000");
		
		erikaMault.addToken("abbr", "Mme");
		erikaMault.addToken("name", "Mault");
		erikaMault.addToken("firstname", "Erika");
		erikaMault.addToken("ville", "Poitiers");
		erikaMault.addToken("address", "45, avenue de la Liberation");
		erikaMault.addToken("postalCode", "86000");
		
		String adMail = "Bonjour {abbr}. {name} {firstname}, nous savons que vous habitez le {address}, dans la ville de {ville}, {postalCode} !\nNous vous trouverons !";
		
		georgeTransformer.transformer(adMail);
		erikaMault.transformer(adMail);
	}

}

