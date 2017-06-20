package model.ataque;

import java.util.ArrayList;

import model.efectos.Efecto;
import model.efectos.Paralizante;

public class ConvierteteEnChocolate implements Ataque {
	public ArrayList<Efecto> efectos;
	
	public ConvierteteEnChocolate(){
		this.efectos = new ArrayList();
		efectos.add(new Paralizante(3));
	}
	
	
	@Override
	public int getDano() {
		return 0;
	}

	@Override
	public int paralizaDurante() {
		return 3;
	}

	@Override
	public ArrayList<Efecto> efectos() {
		return efectos;
	}

}
