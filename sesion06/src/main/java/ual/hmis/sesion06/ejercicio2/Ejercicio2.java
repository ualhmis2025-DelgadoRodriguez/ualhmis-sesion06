package ual.hmis.sesion06.ejercicio2;

// TODO: Auto-generated Javadoc
/**
 * The Class Ejercicio2.
 */
public class Ejercicio2 {
	
	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
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
	 * @param username the username
	 * @param password the password
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