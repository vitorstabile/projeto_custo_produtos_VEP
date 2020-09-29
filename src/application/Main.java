package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.entities.Embalagem;
import model.entities.MP;
import model.entities.Produto;


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
		
		MP mp1 = new MP (89,"800088", "SACO PEBD 1 KG", 0.14);

		MP mp2 = new MP (44,"800043", "ETIQUETA BOPP 100X150 MM", 0.10);
		
		MP mp3 = new MP (19,"800018", "CAIXA DE PAPELÃO 5 KG", 1.60);
		
		MP mp4 = new MP (35,"800034", "COLA BASTÃO", 17.25);

		Produto produto = new Produto(1, "pao de queijo", 72.0);
		
		Embalagem embalagem1 = new Embalagem(1, mp1, produto, 72.0);
				
		Embalagem embalagem2 = new Embalagem(2, mp2, produto, 86.0);
		
		Embalagem embalagem3 = new Embalagem(3, mp3, produto, 14.0);
		
		Embalagem embalagem4 = new Embalagem(4, mp4, produto, 0.1);
		
		
		System.out.println(embalagem1);
		System.out.println(embalagem2);
		System.out.println(embalagem3);
		System.out.println(embalagem4);
		
		embalagem1.setQtEmbalagem(100.0);
		
		System.out.println(embalagem1);
		
		embalagem2.setCustoMP(20.0);
		
		System.out.println(embalagem2);
		
		System.out.println(embalagem2.getCustoEmbalagem());
		
		
	}
}
