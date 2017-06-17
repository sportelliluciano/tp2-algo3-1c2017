package integration.consignas_semana_1;

import model.Unidad;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class FreezerNormal extends Modo {
	
	private int costoKi = 20;
	//private Modo siguienteModo = new GokuKaioKen();
	private int velocidad = 4;
	private int ataqueBasico = 20;
    private int distanciaDeAtaque = 2;
	

	@Override
	public boolean puedeTransformarse(Unidad u) {
		return u.getKi().getMagnitud() >= this.costoKi;
	}

	public Modo transformarA(Unidad u) {
		return null;
	
		// TODO Excepcion para no hay mas transformaciones
	}

	@Override
	public String getNombre() {
		return "Normal";
	}

	@Override
	public int getVelocidad() {
		return velocidad;
	}

	@Override
	public int getAtaqueBasico(){
		return ataqueBasico ;
	}
	
	@Override
	public int getDistanciaDeAtaque(){
		return distanciaDeAtaque;
	}
}
