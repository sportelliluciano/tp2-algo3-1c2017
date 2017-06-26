package view;

import javafx.scene.layout.StackPane;

public class ContenedorHUD extends StackPane {

	private double ancho;
	private double alto;
	
	public ContenedorHUD() {
		
	}
	
	
	public void redimension(int nuevo_alto, int nuevo_ancho) {
		this.alto = nuevo_alto * 0.2;
		this.ancho = nuevo_ancho * 0.6;
		
		if(this.alto < 100)
			this.alto = 100;
		if(this.ancho < 300)
			this.ancho = 300;
	}
}
