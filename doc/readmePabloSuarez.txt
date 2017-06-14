Para hablar con Pablo Suarez:

 - La relacion entre el tablero y sus ocupantes es bastante compleja D: ya en la semana 1 tienen que cumplir lo siguiente:
 
  * El tablero debe conocer todos sus ocupantes y en donde estan.
  * Una unidad debe poder moverse a una nueva posicion si en ella no hay otra unidad y le alcanza con su velocidad (contando con los obstaculos).
  
  Para lo primero, habia varias formas de hacerlo:
  
  * La mas intuitiva, una matriz donde cada Mij puede o no contener una unidad en la posicion (i, j).
  * Una lista u otra estructura que contenga unicamente a los ocupantes, 
    quienes conocen su propia posicion. Por ahora esta estamos usando, aunque no convence mucho...
  * Una mezcla de las 2 de arriba (segun lei, la opcion mas comun en estos juegos aunque mas por optimizacion que por disenio)
    seria una matriz en la que ademas las unidades conocen su posicion.
    
  Profe: cual le parece la mas adecuada? Todas tienen algun lio para implementarse...
  
  
  Sobre las posiciones:
  Lo mas adecuado sería crear la entidades correspondientes, como Tablero y Posición, y que puedan interactuar entre sí. 
  Si luego hay una matriz o alguna otra construcción detrás, esto es un tema de implementación, pero debería
  quedar oculto.
  
  