package view;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import model.Posicionable;

public class FabricaSprites {
	private static FabricaSprites INSTANCE;
	
	Map<String, Image> spritesCargados;
	
	public static FabricaSprites getInstance() {
		if (INSTANCE == null)
			INSTANCE = new FabricaSprites();
		return INSTANCE;
	}
	
	private FabricaSprites() {
		spritesCargados = new HashMap<String, Image>();
	}
	
	public Image getSpritePosicionable(Posicionable p) {
		Image sprite = spritesCargados.get(p.getClass().getName());
		if (sprite == null) {
			sprite = new Image("file:src/view/posicionables/" + p.getClass().getName());
			if (sprite.isError())
				throw new RuntimeException("No se pudo cargar: " + "file:src/view/posicionables/" + p.getClass().getName());
			spritesCargados.put(p.getClass().getName(), sprite);
		}
		
		return sprite;
	}
}
