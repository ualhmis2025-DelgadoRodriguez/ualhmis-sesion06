package ual.hmis.sesion06.ejercicio1;

/**
 * Clase Ejercicio1.
 */
public class Ejercicio1 {
	
	/**
	 * Transformar.
	 *
	 * @param x numero
	 * @return resultado
	 */
	public int transformar(int x) {
		int resultado = 0;
		if (x % 2 == 0) // % Resto de una división entre enteros (mod)
			resultado = transformar (x/2);
		else if (x % 3 == 0)
			resultado = transformar (x/3);
		else if (x % 5 == 0)
			resultado = transformar (x/5);
		else return x;
		return resultado;
	}

}