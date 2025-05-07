package ual.hmis.sesion06.ejercicio3;

public class Ejercicio3 {
    public String enmascararPassword(String password) {
        int length = password.length();
        String resultado;

        if (length >= 5) {
            if (length <= 8) {
                resultado = "********";
            } else if (length >= 12 && length <= 40) {
                resultado = "************";
            } else if (length > 40) {
                resultado = "password demasiado largo";
            } else {
                resultado = "*".repeat(length);
            }
        } else {
            resultado = "password demasiado corto";
        }
        return resultado;
    }
}
