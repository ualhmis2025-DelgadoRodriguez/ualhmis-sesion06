package ual.hmis.sesion06.ejercicio3;

public class Ejercicio3 {

    public String enmascararPassword(String password) {
     int length = password.length();

        if (length < 5) {
            return "password demasiado corto";
        } else if (length >= 5 && length <= 8) {
            return "********";
        } else if (length >= 12 && length <= 40) {
            return "************";
        } else if (length > 40) {
            return "password demasiado largo";
        } else {
            return "*".repeat(length);
        }
    }
}