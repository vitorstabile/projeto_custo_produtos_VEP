package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.entities.Produto;
import model.entities.Receita;
import model.entities.Teste;


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
		
		Receita receita1 = new Receita(2, "massa bolinha de queijo", 41.06);
		Receita receita2 = new Receita(3, "recheio queijo mussarela", 17.59);
		Receita receita3 = new Receita(5, "empano de salgado", 4.50);
		
		Produto produto = new Produto(2, "bolinha de mussarela", 65.00);
		
		Teste teste1 = new Teste(1, produto, receita1, 12.0);
		Teste teste2 = new Teste(2, produto, receita2, 5.0);
		Teste teste3 = new Teste(3, produto, receita3, 3.0);
		
		System.out.println(teste1);
		System.out.println(teste2);
		System.out.println(teste3);
	}
}