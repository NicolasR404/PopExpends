package application.ryn.com.Backend;

public class ModifVariable {
	/* cette class permet de transformer un double en string, en gardent que 2 chiffre apres le dot
	 * Exemple : d = 220.36159
	 * d devient : 	 220.36
	 */
	
	
	
	String variable;
	
	public Double ModifDouble(Double d) {
		double b;
		
		variable =String.valueOf( d);
		for (int i =0; i< variable.length(); i++) {
			if (variable.charAt(i) == '.' && (i+3)< variable.length()) {
				variable = variable.substring(0, i+3);
			}
		}
		b = Double.valueOf(variable);
		
		return b;
	}

}
