package model.atributos_de_unidad;

public class Vida {
	private int vidaMaxima;
	private int vidaActual;
	
	public Vida(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
		this.vidaActual = vidaMaxima;
	}
	
	public boolean estaVivo() {
		return this.vidaActual > 0;
	}
	
	public int getVidaActual() {
		return this.vidaActual;
	}
	
	public int getVidaMaxima() {
		return this.vidaMaxima;
	}
	
	public int getPorcentajeVida() {
		return (this.vidaActual * 100) / this.vidaMaxima;
	}
	
	public void reducirEn(int vida) {
		this.vidaActual -= vida;
		if (this.vidaActual < 0)
			this.vidaActual = 0;
	}
	
	public void incrementarEn(int vida) {
		this.vidaActual += vida;
		if (this.vidaActual > this.vidaMaxima)
			this.vidaActual = this.vidaMaxima;
	}
}
