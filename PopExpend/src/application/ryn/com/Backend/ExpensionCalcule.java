package application.ryn.com.Backend;

public class ExpensionCalcule {
	
	private double populationacutel = 0.00, pourcentage = 0.00,
			total = 0.00, nbepourcent = 0.00, totalephemer = 0.00;
	private int tours = 0;
	
	public ExpensionCalcule(){
		
	}
	
	public ExpensionCalcule(double populationacutel, double pourcentage){
		// on cherche le nombre total de personne
		
		this.setPopulationAcutel(populationacutel);
		this.setPourcentage(pourcentage);
	}
	
	public ExpensionCalcule(double populationacutel, double pourcentage, double total){
		// on cherche le nombre de tours
		
		this.setPopulationAcutel(populationacutel);
		this.setPourcentage(pourcentage);
		this.total = total;
	}
	
	public ExpensionCalcule(double total, int tours, double tmoinsun){
		// on cherche le nombre de population
		
		this.setTotal(total);
		this.setTours(tours);
		this.setNbePourcent(tmoinsun);		
	}
	
	public void ToursPlusUn() {
		
		changeTotalEphemere();
		this.tours += 1;
		this.nbepourcent = this.totalephemer * this.pourcentage;
		this.total = this.totalephemer + this.nbepourcent;
		SetupDoubleString();
	}
	
	public void ToursMoinsUn() {
		
		changeTotalEphemere();
		this.tours -= 1;
		
		this.nbepourcent = this.totalephemer * this.pourcentage;
		this.total = this.total - this.nbepourcent;
		SetupDoubleString();
	}
	
	public void TourFinal() {
		
		if (tours == 0) {this.totalephemer = this.populationacutel;}
		
		this.tours += 1;
		this.populationacutel = this.totalephemer;
		this.nbepourcent = this.populationacutel * this.pourcentage;
		this.totalephemer = this.populationacutel + this.nbepourcent;
		
		SetupDoubleString();
		
	}
	
	private void changeTotalEphemere() {
		
		if (tours > 0) {
			this.totalephemer = this.total;
		} else {
			this.totalephemer = this.populationacutel;
		}
	}
	
	private void SetupDoubleString() {
		// on modifier les double pour que l on affiche que 2 chiffre apres la virguel
		ModifVariable mv = new ModifVariable();

		this.populationacutel = mv.ModifDouble(this.populationacutel);
		this.totalephemer = mv.ModifDouble(this.totalephemer);
		this.total = mv.ModifDouble(this.total);
		this.nbepourcent = mv.ModifDouble(this.nbepourcent);
		
	}

	public double getPopulationAcutel() {
		return populationacutel;
	}

	public void setPopulationAcutel(double populationacutel) {
		this.populationacutel = populationacutel;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getNbePourcent() {
		return nbepourcent;
	}

	public void setNbePourcent(double nbepourcent) {
		this.nbepourcent = nbepourcent;
	}

	public int getTours() {
		return tours;
	}

	public void setTours(int tours) {
		this.tours = tours;
	}

	public double getTotalEphemer() {
		return totalephemer;
	}

	public void setTotalEphemer(double totalephemer) {
		this.totalephemer = totalephemer;
	}
	
	public boolean isTrue() {
		System.out.println("EC isTrue : TotalEphe : "+this.totalephemer+" > Total : "+this.total);
		
		return (this.totalephemer > this.total);
	}

}
