package view;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {

	Button botonDeInicio;
	Stage ventana;
	Scene menuPrincipal, menuDeJuego;
	int DIM_HOR = 600;
	int DIM_VER = 400;
	Image fondoMenu = new Image("file:imagen_menu.jpg");

	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		ventana = primaryStage;
		ventana.setTitle("Guerreros Z vs Enemigos de la Tierra");
		ventana.setOnCloseRequest(e -> cerrarPrograma() );
		
		ImageView fondoMenuVista = new ImageView();
		fondoMenuVista.setImage(fondoMenu);
		fondoMenuVista.setFitHeight(DIM_VER);
		fondoMenuVista.setFitWidth(DIM_HOR);
		
		botonDeInicio = new Button("A luchar");
		botonDeInicio.setOnAction(e ->
					ventana.setScene(menuDeJuego) );
		
		StackPane layoutMenuInicio = new StackPane();
 		layoutMenuInicio.getChildren().addAll(fondoMenuVista, botonDeInicio);
 		BorderPane layoutInicio = new BorderPane();
  		layoutInicio.setCenter(layoutMenuInicio);
  		menuPrincipal = new Scene(layoutInicio, DIM_HOR, DIM_VER);
		StackPane layoutJuego = new StackPane();
		Label textoPlaceholder = new Label("Aca va el juego");
		layoutJuego.getChildren().add(textoPlaceholder);
		menuDeJuego = new Scene(layoutJuego, DIM_HOR, DIM_VER);
		
		ventana.setScene(menuPrincipal);
		ventana.show();
	}
	
	public void cerrarPrograma(){
		ventana.close();
	}
}