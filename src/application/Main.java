package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.entities.Recurso;


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
		
		Recurso recurso = new Recurso(1, "GÁS", 20.0);
		
		System.out.println(recurso);
		
		System.out.println(recurso.getIdRecurso());
		
		recurso.setCustoRecurso(40.0);
		
		System.out.println(recurso.getCustoRecurso());
		
	}
}
