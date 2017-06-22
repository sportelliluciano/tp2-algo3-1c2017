package view;

import javafx.application.*;
import javafx.stage.*;
import model.Equipo;
import model.Juego;
import model.Jugador;
import model.Posicion;
import model.Tablero;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorPosicionInvalida;
import model.personajes.Goku;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {

	Button botonDeInicio;
	Stage ventana;
	Scene menuPrincipal, menuDeJuego;
	int DIM_HOR = 800;
	int DIM_VER = 600;
	Image fondoMenu = new Image("file:imagen_menu.jpg");
	ContenedorTablero layoutJuego;

	Juego juego;
	Tablero tablero;
	
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
		
		iniciarModelo();		
		
		layoutJuego = new ContenedorTablero(ventana, DIM_HOR, DIM_VER, tablero);
		Button botonInicio = new Button("Pasar turno");
		botonInicio.setOnAction(e -> pasarTurno());
		layoutJuego.getChildren().add(botonInicio);
		menuDeJuego = new Scene(layoutJuego, DIM_HOR, DIM_VER);
		
		ventana.setScene(menuPrincipal);
		ventana.show();
	}
	
	private void iniciarModelo() {
		Equipo e1 = new EnemigosDeLaTierra(), e2 = new GuerrerosZ();
		Jugador j1 = new Jugador("Fabio", e1), j2 = new Jugador("Fabio", e2);
		juego = new Juego(j1, j2);
		tablero = juego.getTablero();
	}
	
	private void pasarTurno() {
		juego.siguienteTurno();
		layoutJuego.actualizar();
	}
	
	public void cerrarPrograma(){
		ventana.close();
	}
}