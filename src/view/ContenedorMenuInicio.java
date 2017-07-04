package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.eventos.BotonInicioEventHandler;

public class ContenedorMenuInicio extends Pane {
	public ContenedorMenuInicio(Stage stage, Scene proximaEscena, ContenedorJuego layoutJuego) {
		Image imagen_menu = new Image("file:src/view/imagenes/menu/imagen_menu.jpg");
		BackgroundImage imagenMenu = new BackgroundImage(imagen_menu , BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenMenu) );
		
		Image texto_menu = new Image("file:src/view/imagenes/menu/texto_menu.png");
		ImageView imagenTextoMenu = new ImageView(texto_menu);
		imagenTextoMenu.setFitWidth(800);
		imagenTextoMenu.setFitHeight(100);
		imagenTextoMenu.setLayoutY(20);
		
		Button botonInicio = new Button();
		botonInicio.setGraphic(new ImageView("file:src/view/imagenes/botones/imagen_boton_inicio.png"));
		botonInicio.setStyle("-fx-background-color: transparent;");
		BotonInicioEventHandler botonInicioHandler = new BotonInicioEventHandler(stage, proximaEscena, layoutJuego);
		botonInicio.setOnAction(botonInicioHandler);
		botonInicio.setLayoutX(100);
		botonInicio.setLayoutY(500);
		this.getChildren().addAll(botonInicio, imagenTextoMenu);
	}

}
