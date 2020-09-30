package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	FXMLLoader load;
	Stage primaryStage;
	FenetrePrincipaleControlle fpc;
	
	@Override
	public void start(Stage primaryStage) {
		
		load = new FXMLLoader ();
		this.primaryStage = primaryStage;
		
		try {
			
			load.setLocation(Main.class.getResource("FenetrePrincipale.fxml"));
			AnchorPane root = load.load();
			Scene scene = new Scene(root);
			
			fpc = load.getController();
			fpc.init();
			
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("PopExpends");
			primaryStage.setResizable(false);

			String path = "file:///" +System.getProperty("user.dir") + "/src/Image/Icon%20ExpendPop.png";
			Image img = new Image(path);
			
			primaryStage.getIcons().add(img);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
