package view;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import model.Jugador;

public class ContenedorJuegoTerminado extends StackPane {
	public ContenedorJuegoTerminado(Jugador ganador) {
		Label lbl = new Label("El ganador es: " + ganador.equipo().getNombre());
		this.getChildren().add(lbl);
	}
}
