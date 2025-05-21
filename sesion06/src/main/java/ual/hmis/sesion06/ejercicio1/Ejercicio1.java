package ual.hmis.sesion06.ejercicio1;

// TODO: Auto-generated Javadoc
/**
 * The Class Ejercicio1.
 */
public class Ejercicio1 {
	
	/**
	 * Transformar.
	 *
	 * @param x the x
	 * @return the int
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