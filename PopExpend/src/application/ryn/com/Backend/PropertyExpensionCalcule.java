package application.ryn.com.Backend;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PropertyExpensionCalcule {

	private DoubleProperty populationacutel, pourcentage, total, nbepourcent, totalephemer;
	private IntegerProperty tours;
	private ExpensionCalcule ec;
	
	public  PropertyExpensionCalcule(){}
	
	public PropertyExpensionCalcule( ExpensionCalcule ec){
		this.setEc(ec);
	}
	
	public DoubleProperty getPopulationacutel() {
		return populationacutel;
	}
	
	public void setPopulationacutel(DoubleProperty populationacutel) {
		this.populationacutel = populationacutel;
	}
	
	public void setPopulationacutel(double populationacutel) {
		System.out.println("PEC setPopulationacutel : "+populationacutel);
		this.populationacutel.set(populationacutel);
	}
	
	public DoubleProperty getPourcentage() {
		return pourcentage;
	}
	
	public void setPourcentage(DoubleProperty pourcentage) {
		this.pourcentage = pourcentage;
	}
	
	public void setPourcentage(double pourcentage) {
		
		this.pourcentage.set(pourcentage);;
	}
	
	public DoubleProperty getTotal() {
		return total;
	}
	
	public void setTotal(DoubleProperty total) {
		this.total = total;
	}
	
	public void setTotal(double total) {
		this.total.set(total);
	}
	
	public DoubleProperty getNbepourcent() {
		return nbepourcent;
	}
	
	public void setNbepourcent(DoubleProperty nbepourcent) {
		this.nbepourcent = nbepourcent;
	}
	
	public void setNbepourcent(double nbepourcent) {
		System.out.println("PEC setNbepourcent : "+nbepourcent);
		this.nbepourcent.set(nbepourcent);;
	}
	
	public DoubleProperty getTotalephemer() {
		return totalephemer;
	}
	
	public void setTotalephemer(DoubleProperty totalephemer) {
		this.totalephemer = totalephemer;
	}
	
	public void setTotalephemer(double totalephemer) {
		this.totalephemer.set(totalephemer);;
	}
	
	public IntegerProperty getTours() {
		return tours;
	}
	
	public void setTours(IntegerProperty tours) {
		this.tours = tours;
	}
	
	public void setTours(int tours) {
		this.tours.set(tours);;
	}
	
	public ExpensionCalcule getEc() {
		return ec;
	}
	
	public void setEc(ExpensionCalcule ec) {
		this.ec = ec;
		System.out.println("PEC setEc gogo");
		
		this.setPopulationacutel(new SimpleDoubleProperty(ec.getPopulationAcutel()));
		this.setPourcentage(new SimpleDoubleProperty(ec.getPourcentage()));
		this.setTotal(new SimpleDoubleProperty(ec.getTotal()));
		this.setNbepourcent(new SimpleDoubleProperty(ec.getNbePourcent()));
		this.setTotalephemer(new SimpleDoubleProperty(ec.getTotalEphemer()));
		this.setTours(new SimpleIntegerProperty(ec.getTours()));
		System.out.println("PEC setEc fin : "+ this.getPopulationacutel());
	}
}
