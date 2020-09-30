package application.ryn.com.FrontEnd.Pane;

import application.ryn.com.Backend.ExpensionCalcule;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaneCalculeSimple extends Pane{
	
	/* div en 2
	 * 1- setup calulce
	 * 2- choix tours  
	 */
	
	// pane top
	Label lptpopactuel = new Label(),lptpourcentage = new Label();
	TextField tfptpopactuel = new TextField(), tfptpourcentage = new TextField();
	Button ptconfiramtion = new Button();
	
	// pane down
	Label ltours = new Label(),
			lresultnbepourcent = new Label(), lresulttotal = new Label(), 
			lresulttotalephermer = new Label();
	Label ldrnbepourcent = new Label(), ldrtotal = new Label(), ldrtotalephemer = new Label();
	Button gauche = new Button(), droite = new Button();
	
	int tours;
	ExpensionCalcule ec;
	boolean firsttime = true;
	
	public PaneCalculeSimple() {
		this.setupGraphTop();
		this.setupGraphDown();
		
	}
	
	public void rechargePane() {
		this.getChildren().clear();
		
		this.setupGraphTop();
		this.setupGraphDown();
		
		System.out.println("H : "+ this.getHeight()/2+ ", W : "+this.getWidth()/2);
		
		SetupOnAction();
	}
	
	private void setupGraphTop() {
		
		lptpopactuel.setLayoutX(10);
		lptpopactuel.setLayoutY(15);
		lptpopactuel.setPrefSize(105,25);
		lptpopactuel.setText("Votre population : ");
		lptpopactuel.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		
		lptpourcentage.setLayoutX(225);
		lptpourcentage.setLayoutY(15);
		lptpourcentage.setPrefSize(145,25);
		lptpourcentage.setText("Votre pourcentage (0.10) :");
		lptpourcentage.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		
		tfptpopactuel.setLayoutX(120);
		tfptpopactuel.setLayoutY(15);
		tfptpopactuel.setPrefSize(100,25);
		tfptpopactuel.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
		
		tfptpourcentage.setLayoutX(375);
		tfptpourcentage.setLayoutY(15);
		tfptpourcentage.setPrefSize(100,25);
		tfptpourcentage.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
		
		ptconfiramtion.setLayoutX(380);
		ptconfiramtion.setLayoutY(45);
		ptconfiramtion.setPrefSize(90,25);
		ptconfiramtion.setText("Confirmation");
		ptconfiramtion.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		
		this.getChildren().addAll(lptpopactuel, lptpourcentage, tfptpopactuel, tfptpourcentage, ptconfiramtion);
	}
	
	private void setupGraphDown() {

		// la navigation
		gauche.setLayoutX(50);
		gauche.setLayoutY(175);
		gauche.setPrefSize(105,25);
		gauche.setText("Gauche");
		gauche.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		
		ltours.setLayoutX(160);
		ltours.setLayoutY(175);
		ltours.setPrefSize(105,25);
		ltours.setText("Nbe tours");
		ltours.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		
		droite.setLayoutX(270);
		droite.setLayoutY(175);
		droite.setPrefSize(105,25);
		droite.setText("Droite");
		droite.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		
		// Le resultat
		ldrtotalephemer.setLayoutX(10);
		ldrtotalephemer.setLayoutY(100);
		ldrtotalephemer.setPrefSize(125,25);
		ldrtotalephemer.setText("Votre population T+1 : ");
		ldrtotalephemer.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		
		lresulttotalephermer.setLayoutX(140);
		lresulttotalephermer.setLayoutY(100);
		lresulttotalephermer.setPrefSize(105,25);
		lresulttotalephermer.setText("");
		lresulttotalephermer.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
		
		ldrnbepourcent.setLayoutX(250);
		ldrnbepourcent.setLayoutY(100);
		ldrnbepourcent.setPrefSize(120,25);
		ldrnbepourcent.setText("nbe du pourcentage :");
		ldrnbepourcent.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		
		lresultnbepourcent.setLayoutX(375);
		lresultnbepourcent.setLayoutY(100);
		lresultnbepourcent.setPrefSize(105,25);
		lresultnbepourcent.setText("");
		lresultnbepourcent.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));

		ldrtotal.setLayoutX(100);
		ldrtotal.setLayoutY(130);
		ldrtotal.setPrefSize(105,25);
		ldrtotal.setText("Votre Total");
		ldrtotal.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		
		lresulttotal.setLayoutX(210);
		lresulttotal.setLayoutY(130);
		lresulttotal.setPrefSize(105,25);
		lresulttotal.setText("");
		lresulttotal.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
		
		this.getChildren().addAll(gauche, ltours, droite,  lresultnbepourcent, lresulttotal, lresulttotalephermer,
				ldrnbepourcent, ldrtotal, ldrtotalephemer);
	}
	
	private void SetupOnAction() {
		
		ptconfiramtion.setOnAction(new EventHandler<ActionEvent> (){
			
			public void handle(ActionEvent ae) {
				
				ec = new ExpensionCalcule( Double.valueOf( tfptpopactuel.getText()), Double.valueOf( tfptpourcentage.getText()));
				ec.ToursPlusUn();
				
				lresultnbepourcent.setText(String.valueOf( ec.getNbePourcent()));
				lresulttotal.setText( String.valueOf( ec.getTotal()));
				
				actuTexte();
			}
		});
		
		gauche.setOnAction(new EventHandler<ActionEvent> (){
			
			public void handle(ActionEvent ae) {
				
				if (tours > 0) {
				ec.ToursMoinsUn();
				
				actuTexte();
				ltours.setText("Tours "+ ec.getTours());
				}
			}
		});

		droite.setOnAction(new EventHandler<ActionEvent> (){
	
			public void handle(ActionEvent ae) {
				
				ec.ToursPlusUn();
				actuTexte();
				ltours.setText("Tours "+ ec.getTours());
			}
		});
		
		
	}
	
	private void actuTexte() {
		lresultnbepourcent.setText(String.valueOf( ec.getNbePourcent()));
		lresulttotal.setText( String.valueOf( ec.getTotal()));
		
		lresulttotalephermer.setText( String.valueOf(ec.getTotalEphemer()));
		
		tours = ec.getTours();
	}
}
	
