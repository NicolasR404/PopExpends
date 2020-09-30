package application.ryn.com.Backend;

import java.util.ArrayList;
import java.util.List;

public class ListExpensionCalcule {
	/* class principale du PaneCalculeTableau, elle permet de stocker et utiliser
	 *  pour calculer les different tours pour arriver au montant max 
	 */
	
	private List<ExpensionCalcule> lec = new ArrayList<ExpensionCalcule>();
	private List<PropertyExpensionCalcule> lpec = new ArrayList<PropertyExpensionCalcule>();
	PropertyExpensionCalcule pec ;
	
	public ListExpensionCalcule(ExpensionCalcule ect) {
		setupList(ect);
	}
	
	private void setupList(ExpensionCalcule ect) {
		
		ExpensionCalcule ec = ect;

		while(ec.isTrue() != true) {
			
			lec.add(ec);
			ec.TourFinal();
			lpec.add( new PropertyExpensionCalcule(ec));
		}
	}
	
	public List<PropertyExpensionCalcule> getPropetyList() {
		return lpec;
	}
	
	public List<ExpensionCalcule> getList() {
		return lec;
	}
	
}
