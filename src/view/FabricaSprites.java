package view;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import model.Consumible;
import model.Posicionable;
import model.Unidad;
import model.consumibles.EsferaDelDragon;
import model.consumibles.NubeVoladora;
import model.consumibles.Semilla;

public class FabricaSprites {
	private static FabricaSprites INSTANCE;
	final private String BASE_PATH = "src/view/imagenes";
	
	Map<String, Image> spritesCargados;
	
	public static FabricaSprites getInstance() {
		if (INSTANCE == null)
			INSTANCE = new FabricaSprites();
		return INSTANCE;
	}
	
	private FabricaSprites() {
		spritesCargados = new HashMap<String, Image>();
	}
	
	private Image getSprite(String ruta) {
		String rutaFull = "file:" + BASE_PATH + ruta;
		Image sprite = spritesCargados.get(rutaFull);
		if (sprite == null) {
			sprite = new Image(rutaFull);
			if (sprite.isError())
				throw new RuntimeException("No se pudo cargar: " + rutaFull);
			spritesCargados.put(ruta, sprite);
		}
		
		return sprite;
	}
	
	private Image getSpriteUnidad(Unidad u) {
		String nombreUnidad = u.getClass().getSimpleName().toLowerCase();
		String nombreModo = u.getNombre().toLowerCase().replace(' ', '-');
		return getSprite("/unidad/" + nombreUnidad + "/" + nombreModo + ".png");
	}
	
	private Image getSpriteConsumible(Consumible c) {
		if (c instanceof Semilla)
			return getSprite("/consumible/semilla.png");
		if (c instanceof EsferaDelDragon)
			return getSprite("/consumible/esfera.png");
		if (c instanceof NubeVoladora)
			return getSprite("/consumible/nube.png");
		throw new RuntimeException("Consumible no implementado");
	}
	
	public static Image getSpritePosicionable(Posicionable p) {
		FabricaSprites fabrica = getInstance();
		
		if (p instanceof Unidad)
			return fabrica.getSpriteUnidad((Unidad)p);
		
		return fabrica.getSpriteConsumible((Consumible)p);
	}
	
	public static Image getSpriteBoton(String accion) {
		FabricaSprites fabrica = getInstance();
		return fabrica.getSprite("/botones/imagen_boton_" + accion + ".png");
	}
}
