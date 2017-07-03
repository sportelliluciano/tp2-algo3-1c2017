package view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class ContenedorStatsVacio extends ContenedorStats {
	private Label leyenda;
	public ContenedorStatsVacio(String mensaje, double maxAlto) {
		leyenda = new Label(mensaje);
		leyenda.setStyle("-fx-text-fill: white;-fx-font-size: 18px;");
		super.getChildren().add(leyenda);
		super.setPadding(new Insets(10));
	}
	
	public void actualizar() {
		
	}
}
