package application.ryn.com.FrontEnd.Pane;

import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

import application.ryn.com.Backend.ExpensionCalcule;
import application.ryn.com.Backend.ListExpensionCalcule;
import application.ryn.com.Backend.PropertyExpensionCalcule;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaneCalculeTableau extends Pane{
	// pop, pourcent, total a ateindre
	
	
	// Gui du pane
	Label lpop = new Label(), lpourcent = new Label(), ltotal = new Label();
	TextField tfpop = new TextField(), tfpourcent = new TextField(), tftotal = new TextField();
	Button confirmcalule = new Button();

	// Objet : 
	private ExpensionCalcule ec = new ExpensionCalcule();
	ListExpensionCalcule llec;
	List<ListExpensionCalcule> d2lec= new ArrayList<ListExpensionCalcule>();
	
	// Gui TreeTable :
	TreeTableView<PropertyExpensionCalcule> ttv = new TreeTableView<PropertyExpensionCalcule>();
	
	TreeTableColumn<PropertyExpensionCalcule, Number> ttcpop = new TreeTableColumn<PropertyExpensionCalcule, Number>("Population");
	TreeTableColumn<PropertyExpensionCalcule, Number> ttcpourcent = new TreeTableColumn<PropertyExpensionCalcule, Number>("Pourcent");
	TreeTableColumn<PropertyExpensionCalcule, Number> ttctotal = new TreeTableColumn<PropertyExpensionCalcule, Number>("Total");
	TreeTableColumn<PropertyExpensionCalcule, Number> ttctours = new TreeTableColumn<PropertyExpensionCalcule, Number>("Tours");

	// list des TreeItem :
	List<TreeItem<PropertyExpensionCalcule>> drootti= new ArrayList<TreeItem<PropertyExpensionCalcule>>();
		// d1ti = liste des ville soumis au 1er tours du expension cal
	List<TreeItem<PropertyExpensionCalcule>> d2tit= new ArrayList<TreeItem<PropertyExpensionCalcule>>();
		// d2tit = list temporaire liee au tours suivant (2 ; toursMax) de telle ville (forcement la dernier cree)
	
	// variable liee au tree
	String structa = "Ville NÅã ", structb = "1"; // structa = valeur fixe, structb = id ville
	
	
	
	public PaneCalculeTableau() {
		setupGui();
		setupGuiTree();
	}
	
	private void setupGui() {
		// setup des different element graphique
		
		System.out.println("PCT SetupGui start");
		lpop.setLayoutX(10);
		lpop.setLayoutY(15);
		lpop.setPrefSize(105,25);
		lpop.setText("Votre population");
		lpop.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		
		tfpop.setLayoutX(120);
		tfpop.setLayoutY(15);
		tfpop.setPrefSize(100,25);
		tfpop.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
		
		lpourcent.setLayoutX(225);
		lpourcent.setLayoutY(15);
		lpourcent.setPrefSize(145,25);
		lpourcent.setText("Votre pourcentage (0.01)");
		lpourcent.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		
		tfpourcent.setLayoutX(375);
		tfpourcent.setLayoutY(15);
		tfpourcent.setPrefSize(105,25);
		tfpourcent.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
		
		ltotal.setLayoutX(10);
		ltotal.setLayoutY(45);
		ltotal.setPrefSize(100,25);
		ltotal.setText("Votre total");
		ltotal.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		
		tftotal.setLayoutX(120);
		tftotal.setLayoutY(45);
		tftotal.setPrefSize(100,25);
		tftotal.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
		
		confirmcalule.setLayoutX(380);
		confirmcalule.setLayoutY(45);
		confirmcalule.setPrefSize(90,25);
		confirmcalule.setText("Lancer Calcule");
		confirmcalule.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));
		
		confirmcalule.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent ae) {
			
				ec = new ExpensionCalcule( Double.valueOf(tfpop.getText()),
						Double.valueOf(tfpourcent.getText()),
						Double.valueOf(tftotal.getText())
						);
				 llec = new ListExpensionCalcule(ec);
				 setupList();
			}
		});
		this.getChildren().addAll(lpop, lpourcent, ltotal, tfpop, tfpourcent, tftotal, confirmcalule);
		System.out.println("PCT SetupGui fin");
	}
	
	private void setupList() {
		// gestion de la list, les item du TreeTable
		
		this.d2lec.add(llec);
		
		 TreeItem<PropertyExpensionCalcule> itroot = new TreeItem<PropertyExpensionCalcule>(llec.getPropetyList().get(0));
		
		for (int i =1; i<llec.getPropetyList().size() ; i ++) {
			 TreeItem<PropertyExpensionCalcule> it = new TreeItem<PropertyExpensionCalcule>(llec.getPropetyList().get(i));
			 itroot.getChildren().add(it);
			 
			}
		
		ttv.setRoot(itroot);
		 
	}
	
	private void setupGuiTree() {
		// setup du TreeTableView
		
		ttv.setLayoutX(0);
		ttv.setLayoutY(80);
		ttv.setPrefSize( 505, 216); // 556?, 216
		
		ttcpop.setCellValueFactory(t -> t.getValue().getValue().getPopulationacutel());
		ttcpourcent.setCellValueFactory(t -> t.getValue().getValue().getNbepourcent());
		ttctotal.setCellValueFactory(t -> t.getValue().getValue().getTotalephemer());
		ttctours.setCellValueFactory(t -> t.getValue().getValue().getTours());
		
		ttv.getColumns().addAll( ttctours, ttcpop, ttcpourcent, ttctotal);
		
		this.getChildren().add(ttv);
	}
	
	
	

}
