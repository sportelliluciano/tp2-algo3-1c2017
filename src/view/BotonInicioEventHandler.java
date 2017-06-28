package view.eventos;

import javafx.event.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonInicioEventHandler implements EventHandler<ActionEvent> {

	Stage stage;
	Scene proximaEscena;
	
	public BotonInicioEventHandler(Stage stage, Scene proximaEscena){
		this.stage = stage;
		this.proximaEscena = proximaEscena;
	}
	
	@Override
	public void handle(ActionEvent actionEvent){
		stage.setScene(proximaEscena);
	}
}
