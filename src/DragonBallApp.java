import javafx.application.*;
import javafx.stage.*;
import model.Juego;
import model.Jugador;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import view.ContenedorJuego;
import view.ContenedorMenuInicio;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class DragonBallApp extends Application {

	Button botonDeInicio;
	Stage ventana;
	Scene escenaMenu, escenaJuego;
	ContenedorJuego layoutJuego;
	int DIM_HOR = 800;
	int DIM_VER = 600;
	Jugador jugador1;
	Jugador jugador2;
	Juego juego;

	
	public void start(Stage primaryStage) {
		ventana = primaryStage;
		ventana.setTitle("Guerreros Z vs Enemigos de la Tierra");
		ventana.setOnCloseRequest(e -> cerrarPrograma() );
		
		ContenedorMenuInicio contenedorMenuInicio = new ContenedorMenuInicio(ventana, iniciarJuego() );
		Scene escenaMenu = new Scene(contenedorMenuInicio, DIM_HOR, DIM_VER);

		ventana.setScene(escenaMenu);
		ventana.show();
	}
	
	public Scene iniciarJuego(){
		iniciarLayoutJuego();
		ventana.widthProperty().addListener((obs, oldVal, newVal) -> {
		     layoutJuego.redimensionar(ventana.widthProperty().doubleValue(), ventana.heightProperty().doubleValue());
		});

		ventana.heightProperty().addListener((obs, oldVal, newVal) -> {
			 layoutJuego.redimensionar(ventana.widthProperty().doubleValue(), ventana.heightProperty().doubleValue());
		});
		
		escenaJuego = new Scene(layoutJuego, DIM_HOR, DIM_VER);
		escenaJuego.getStylesheets().add("view/style.css");
		return escenaJuego;
	}
	
	public void iniciarLayoutJuego(){

		jugador1 = new Jugador("Fabio", new GuerrerosZ() );
		jugador2 = new Jugador("Marito", new EnemigosDeLaTierra() );
		layoutJuego = new ContenedorJuego(new Juego(jugador1, jugador2) );
		Image imagenTablero = new Image("file:fondo_juego.jpg");
		BackgroundImage fondoJuego = new BackgroundImage(imagenTablero, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		layoutJuego.setBackground(new Background(fondoJuego) );
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void cerrarPrograma(){
		System.out.println("Se cerr� el juego.");
		ventana.close();
	}
} 