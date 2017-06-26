package view;

import javafx.application.*;
import javafx.stage.*;
import model.Juego;
import model.Jugador;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {

	Button botonDeInicio;
	Stage ventana;
	Scene escenaMenu, escenaJuego;
	ContenedorJuego layoutJuego;
	int DIM_HOR = 800;
	int DIM_VER = 600;
	Juego juego;
	Jugador jugador1;
	Jugador jugador2;
	
	public void start(Stage primaryStage) {
		ventana = primaryStage;
		ventana.setTitle("Guerreros Z vs Enemigos de la Tierra");
		ventana.setOnCloseRequest(e -> cerrarPrograma() );
		
		ventana.setScene(crearEscenaMenu() );
		ventana.show();
	}
	
	public Scene iniciarJuego(){
		iniciarLayoutJuego(); // TODO: Ac� faltar�a hacer que el layout que se inicie sea el nuevo objeto tablero
		
		/* Ac� va a ir el c�digo que pone en el tablero los personsajes */
		ventana.widthProperty().addListener((obs, oldVal, newVal) -> {
		     layoutJuego.redimensionar(ventana.widthProperty().doubleValue(), ventana.heightProperty().doubleValue());
		});

		ventana.heightProperty().addListener((obs, oldVal, newVal) -> {
			layoutJuego.redimensionar(ventana.widthProperty().doubleValue(), ventana.heightProperty().doubleValue());
		});
		
		escenaJuego = new Scene(layoutJuego, DIM_HOR, DIM_VER);
		return escenaJuego;
	}
	
	public void iniciarLayoutJuego(){
		layoutJuego = new ContenedorJuego(new Juego(new Jugador("Fabio", new GuerrerosZ()), new Jugador("Marito", new EnemigosDeLaTierra())));
		Label textoPlaceholder = new Label("Aca va el juego");
		textoPlaceholder.setLayoutX(DIM_HOR/2);
		textoPlaceholder.setLayoutY(DIM_VER/2);
		ImageView fondoJuego = new ImageView("file:fondo_juego.jpg");
		fondoJuego.setFitHeight(DIM_VER);
		fondoJuego.setFitWidth(DIM_HOR);
		layoutJuego.getChildren().addAll(fondoJuego,textoPlaceholder);
	}
	
	public Scene crearEscenaMenu(){
		ImageView fondoMenuVista = new ImageView("file:imagen_menu.jpg");
		fondoMenuVista.setFitHeight(DIM_VER);
		fondoMenuVista.setFitWidth(DIM_HOR);
		
		botonDeInicio = new Button("A luchar");
		botonDeInicio.setOnAction(e ->
					ventana.setScene(iniciarJuego() ));
		botonDeInicio.setLayoutX(200);
		botonDeInicio.setLayoutY(220);
		
		Pane layoutMenuInicio = new Pane();
		layoutMenuInicio.getChildren().addAll(fondoMenuVista, botonDeInicio);
		BorderPane layoutInicio = new BorderPane();
		layoutInicio.setCenter(layoutMenuInicio);
		escenaMenu = new Scene(layoutInicio, DIM_HOR, DIM_VER);
		
		return escenaMenu;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void cerrarPrograma(){
		//System.out.println("Se cerr� el juego.");
		ventana.close();
	}
} 