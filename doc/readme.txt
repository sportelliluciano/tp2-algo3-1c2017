Buenas gente!

Mi intencion seria tirar ideas aca, pa ver como diseñar e implementar esta cosa...

* En que idioma codeamos? Tenemos 2 opciones:

 - Espaniol (Que seria mas bien spanglish)
 - Ingles (por esta vota Emiliano :3 pero si alguno no esta muy ducho se complica...)
 - Español (1 voto de Lucho)
 
* Como dividimos el trabajo?

 - 	Por ahora diria que cada uno aporte donde se le ocurre algo, 
 	pero por favor siempre commits CHIQUITOS, onda un par de lineas maximo.
 [Lucho] - Propongo integración continua y TDD. 
	 - No dejar builds en el repo que no funcionen.
 	
* Como es el tema de buildear?

 -	En el enunciado dice que tenemos que hacer un ant, q es tipo un make creo, con
 	el build, a pesar de que eclipse lo hace solito... D: yo no lo se hacer (aun) y
 	si alguien sabe ya golazo.
 	
* Como implementamos un personaje, el tablero, etc etc.

 -	Por ahora es pronto para escribir algo supongo. Primero que nada deberiamos tener
 	identificadas las entidades del juego, y tirar todas las ideas posibles sobre como
 	estructurarlas en clases.

 - [Emi] Entidades (Señaladas entre comillas simples):
	o) Los 2 'Jugadores', manipulando el 'juego' mediante la 'interfaz grafica'.
	o) Un 'Mapa' o Tablero cuadriculado, de 'Tamaño' aun indefinido, cuyas 'celdas' contienen personajes o consumibles.
	o) Los 'Personajes', siendo inicialmente tres de un jugador y tres del otro, y dependera del 'bando' ('buenos' o 'malos)
	que cada jugador elija los personajes que le toque.
	o) Los 'consumibles', en particular 'esfera' 'nube' o 'semilla'.
	o) 'Stats' de un personaje, que podrian clasificarse en:
		- Propios del tipo de personaje: Sus 'puntos de vida maximo', su 'nombre', su 'ataque especial', su
		'habilidad pasiva', si la tiene (Solo Goku), y las 'transformaciones' que puede tener, con sus respectivas
		'condiciones de activacion'.
		- Propios de su transformacion: Su 'poder de pelea', su 'rango de ataque' y 'velocidad de movimiento'.
		- Propios de una instancia del personaje*: El jugador que lo controla, su 'posicion' en el tablero,
		sus 'puntos de vida actuales', la 'cantidad de ki' que posee, los 'efectos temporales' de consumibles
		recientemente obtenidos, y la transformacion actual.

	(Ahora cosas algo mas rebuscadas)
	o) Un 'turno', y como afecta al jugador y sus personajes.
	o) Una 'camara' por jugador, como parte de la interfaz grafica, para que se centre en el ultimo personaje con el que
	realizo una accion.

 	

* Digo instancia pero no me meto en la implementacion aun, ojo!