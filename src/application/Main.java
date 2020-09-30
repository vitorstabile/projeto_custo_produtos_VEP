package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.entities.Produto;
import model.entities.Recurso;
import model.entities.Utilidade;


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
		
		Recurso recurso1 = new Recurso(1, "energia", 0.12);
		Recurso recurso2 = new Recurso(4, "mod pao de queijo", 0.18);
		Recurso recurso3 = new Recurso(5, "depreciacao", 0.06);
		
		Produto produto = new Produto (1, "pao de queijo", 72.00);
		
		Utilidade utilidade1 = new Utilidade(1, produto, recurso1);
		Utilidade utilidade2 = new Utilidade(2, produto, recurso2);
		Utilidade utilidade3 = new Utilidade(3, produto, recurso3);
		
		System.out.println(utilidade1);
		System.out.println(utilidade2);
		System.out.println(utilidade3);
		
	}
}
