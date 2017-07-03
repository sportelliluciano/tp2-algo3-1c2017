package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Unidad;

public class ContenedorStats extends HBox {
	
	private VBox atributos;
	private Label nombreUnidad = new Label(), vida = new Label(), ki = new Label();
	private ImageView imgPersonaje;
	private Unidad personaje;
	
	public ContenedorStats(Unidad p, double maxAlto) {
		personaje = p;
		nombreUnidad.setStyle("-fx-text-fill: white;-fx-font-size: 20px;");
		vida.setStyle("-fx-text-fill: white;");
		ki.setStyle("-fx-text-fill: white;");
		
		atributos = new VBox(nombreUnidad, vida, ki);
		atributos.setPadding(new Insets(0, 0, 0, 15));
		
		imgPersonaje = new ImageView(FabricaSprites.getSpritePosicionable(p));
		imgPersonaje.setPreserveRatio(true);
		imgPersonaje.maxHeight(maxAlto * 0.7);
		imgPersonaje.setFitHeight(maxAlto * 0.7);
		
		
		this.setPadding(new Insets(5, 5, 0, 0));
		getChildren().addAll(imgPersonaje, atributos);
		actualizar();
	}

	public void actualizar() {
		nombreUnidad.setText(personaje.getNombre());
		vida.setText("Vida: " + personaje.getVida().getVidaActual() + "/" + personaje.getVida().getVidaMaxima());
		ki.setText("Ki: " + personaje.getKi().getMagnitud());
	}

}
