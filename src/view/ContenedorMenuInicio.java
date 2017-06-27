package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.eventos.BotonInicioEventHandler;

public class ContenedorMenuInicio extends Pane {
	Stage stage;
	
	public ContenedorMenuInicio(Stage stage, Scene proximaEscena){
		this.stage = stage;
		
		Image imagen_menu = new Image("file:imagen_menu.jpg");
		BackgroundImage imagenMenu = new BackgroundImage(imagen_menu , BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenMenu) );
		
		Button botonInicio = new Button();
		botonInicio.setText("A luchar!");
		BotonInicioEventHandler botonInicioHandler = new BotonInicioEventHandler(stage, proximaEscena);
		botonInicio.setOnAction(botonInicioHandler);
		botonInicio.setLayoutX(300);
		botonInicio.setLayoutY(300);
		this.getChildren().add(botonInicio);
	}

}
