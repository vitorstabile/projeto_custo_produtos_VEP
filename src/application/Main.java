package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.entities.Receita;


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
		
		Receita receita = new Receita(1, "Receita Teste", 20.0);
		
		System.out.println(receita);
		
		System.out.println(receita.getDataReceita());
		
		receita.setRendLiqReceita(40.0);

		System.out.println(receita.getRendLiqReceita());
	}
}
