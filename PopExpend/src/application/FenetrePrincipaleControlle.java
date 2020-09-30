package application;

import application.ryn.com.Backend.ModifVariable;
import application.ryn.com.FrontEnd.Pane.PaneCalculeSimple;
import application.ryn.com.FrontEnd.Pane.PaneCalculeTableau;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class FenetrePrincipaleControlle {
	
	@FXML
	MenuItem calculeseul;
	
	@FXML
	MenuItem calculetab;
	
	@FXML
	Pane paneprincipale;
	
	PaneCalculeSimple pcs = new PaneCalculeSimple();
	PaneCalculeTableau pct = new PaneCalculeTableau();
	
	Label limage = new Label("");
	
	public FenetrePrincipaleControlle(){

	}

	public void init() {
		System.out.println("Tu pue la merde");
		
		paneprincipale.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, null, null)));
		
		String path = "file:///" +System.getProperty("user.dir") + "/src/Image/Logo%20NR.png";
		
		System.out.println("le Path est : "+System.getProperty("user.dir")+ ", voila mainteneant le path : "+path);
		
		Image img = new Image(path); //"file:///C:/Users/Nico/eclipse-workspace/PopExpend/src/Image/Logo%20NR.png"
		ImageView iv = new ImageView(img);
		//iv.resize(100, height);
		limage.setPrefSize(100, 100);
		limage.setLayoutX(30);
		limage.setLayoutY(30);
		limage.setGraphic(iv);
		
		Label lrecttext = new Label("");
		lrecttext.setPrefSize(215, 75);
		lrecttext.setLayoutX(195);
		lrecttext.setLayoutY(75);
		lrecttext.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
		
		
		Label ltext = new Label (" Bienvenue sur le Logiciel PopExpend");
		ltext.setPrefSize(200, 60);
		ltext.setLayoutX(200);
		ltext.setLayoutY(80);
		ltext.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, null, null)));
		ltext.setTextAlignment(TextAlignment.CENTER);
		
		paneprincipale.getChildren().addAll(limage, lrecttext, ltext);
		
		calculeseul.setOnAction(new EventHandler<ActionEvent> (){
			
			public void handle(ActionEvent ae) {
				DechargePane();
				
				pcs.setLayoutX(0);
				pcs.setLayoutY(0);
				pcs.setPrefSize(paneprincipale.getPrefWidth(), paneprincipale.getPrefHeight());
				pcs.rechargePane();
				paneprincipale.getChildren().add(pcs);
			}
			
		});
		
		calculetab.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent ae) {
				DechargePane();
				//pct
				pct.setLayoutX(0);
				pct.setLayoutY(0);
				pct.setPrefSize(paneprincipale.getPrefWidth(), paneprincipale.getPrefHeight());
				paneprincipale.getChildren().add(pct);
			}
		});
	}
	
	private void DechargePane() {
		paneprincipale.getChildren().clear();
	}
	
}
