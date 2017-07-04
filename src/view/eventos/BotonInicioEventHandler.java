package view.eventos;

import javafx.event.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ContenedorJuego;

public class BotonInicioEventHandler implements EventHandler<ActionEvent> {

	Stage stage;
	Scene proximaEscena;
	ContenedorJuego layoutJuego;
	
	public BotonInicioEventHandler(Stage stage, Scene proximaEscena, ContenedorJuego layoutJuego){
		this.stage = stage;
		this.proximaEscena = proximaEscena;
		this.layoutJuego = layoutJuego;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		stage.setScene(proximaEscena);
		layoutJuego.iniciarJuego();
	}
}
