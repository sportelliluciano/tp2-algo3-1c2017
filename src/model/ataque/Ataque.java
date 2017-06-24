package model.ataque;

import java.util.ArrayList;

import model.efectos.Efecto;

public interface Ataque {
	public int getDano();
	public ArrayList<Efecto> efectos();	
}
