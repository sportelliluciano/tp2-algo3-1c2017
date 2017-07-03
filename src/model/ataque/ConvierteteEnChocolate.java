package model.ataque;

import java.util.ArrayList;

import model.efectos.Efecto;
import model.efectos.Paralizante;

public class ConvierteteEnChocolate implements Ataque {
	public ArrayList<Efecto> efectos;
	
	public ConvierteteEnChocolate(){
		this.efectos = new ArrayList<Efecto>();
		efectos.add(new Paralizante(3));
	}
	
	@Override
	public int getDano(int poderDePeleaPropio) {
		return 0;
	}

	@Override
	public ArrayList<Efecto> efectos() {
		return efectos;
	}

}
