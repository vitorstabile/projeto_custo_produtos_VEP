package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.entities.MP;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*launch(args);*/
		
		MP mp1 = new MP(1, "800009", "AZEITE", 6.12);
		
		MP mp2 = new MP(28, "800027", "CEBOLA IN NATURA", 5.1);
		
		System.out.println(mp1);
		System.out.println(mp2);
		
		System.out.println(mp1.getCodigoMP());
		
		mp2.setCustoMP(10.2);
		
		System.out.println(mp2.getCustoMP());
		
	}
}
