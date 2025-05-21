package ual.hmis.sesion06.ejercicio4;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MezclaLineal.
 */
public class MezclaLineal {
    
    /**
     * Mezclar.
     *
     * @param lista1 the lista 1
     * @param lista2 the lista 2
     * @return the list
     */
    public List<Integer> mezclar(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) <= lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }

        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }

        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }

        return resultado;
    }
}
