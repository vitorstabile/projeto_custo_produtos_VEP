package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.entities.Ingrediente;
import model.entities.MP;
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
		
		MP mp1 = new MP (1,"111", "mp1", 20.0);
		
		MP mp2 = new MP (2,"222", "mp2", 30.0);
		
		Receita receita = new Receita(1, "Receita Teste", 20.0);
		
		System.out.println(receita);
		
		Ingrediente ingrediente1 = new Ingrediente(1, mp1, receita, 30.0, 5.0);
		
		Ingrediente ingrediente2 = new Ingrediente(2, mp2, receita, 20.0, 5.0);
		
		receita.addIngrediente(ingrediente1);
		
		System.out.println(receita);
		
		receita.addIngrediente(ingrediente2);
		
		System.out.println(receita);
		
		ingrediente2.setQtIngredienteBruto(40.0);
		
		System.out.println(receita);
		
		receita.setRendLiqReceita(40.0);
		
		System.out.println(receita);
		
		receita.removeIngrediente(ingrediente2);
		
		System.out.println(receita);
		
	}
}
