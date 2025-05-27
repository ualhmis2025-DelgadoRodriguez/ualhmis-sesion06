package ual.hmis.sesion06.ejercicio2;

/**
 * Clase Ejercicio2.
 */
public class Ejercicio2 {
	
	/**
	 * Login.
	 *
	 * @param username nombre del usuario
	 * @param password password del usuario
	 * @return el resultado de comprobar el login en la base de datos
	 */
	public boolean login (String username, String password){
		// comprobar que sean distintos de vacio
		if (username.isEmpty() || password.isEmpty())
			return false;
		// comprobar que la longitud sea < 30
		if (username.length()>= 30 || password.length()>=30)
			return false;
		// llamar al método de la bbdd
		return compruebaLoginEnBD(username, password);

	}

	/**
	 * Comprueba login en BD.
	 *
	 * @param username nombre del usuario
	 * @param password password del usuario
	 * @return true, if successful
	 */
	public boolean compruebaLoginEnBD
	(String username, String password){
		// método mock (simulado)
		if (username.equals("user") && password.equals("pass"))
			return true;
		else
			return false;
	}
}