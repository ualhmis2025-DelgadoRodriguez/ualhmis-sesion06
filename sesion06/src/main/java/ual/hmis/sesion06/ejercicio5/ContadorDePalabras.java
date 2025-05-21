package ual.hmis.sesion06.ejercicio5;

import java.io.*;
import java.util.*;

/**
 * Clase ContadorDePalabras.
 */
public class ContadorDePalabras {
    
    /**
     * Procesar archivo.
     *
     * @param archivo archivo
     * @return el contador de palabras
     */
    public Map<String, Integer> procesarArchivo(String archivo) {
        Map<String, Integer> contadorDePalabras = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                for (String palabra : palabras) { 
                    palabra = palabra.toLowerCase().replaceAll("[^a-záéíóúüñ]", "").trim();
                    if (!palabra.isEmpty()) {
                        contadorDePalabras.put(palabra, contadorDePalabras.getOrDefault(palabra, 0) + 1);
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contadorDePalabras;
    }

    /**
     * Obtener palabras alfabeticamente.
     *
     * @param archivo archivo
     * @return palabras
     */
    public List<String> obtenerPalabrasAlfabeticamente(String archivo) {
        Map<String, Integer> contadorDePalabras = procesarArchivo(archivo);
        List<String> palabras = new ArrayList<>(contadorDePalabras.keySet());
        Collections.sort(palabras);
        return palabras;
    }

    /**
     * Obtener palabras por ocurrencias.
     *
     * @param archivo archivo
     * @return palabras ordenadas
     */
    public List<String> obtenerPalabrasPorOcurrencias(String archivo) {
        Map<String, Integer> contadorDePalabras = procesarArchivo(archivo);
        List<Map.Entry<String, Integer>> listaDeEntradas = new ArrayList<>(contadorDePalabras.entrySet());
        listaDeEntradas.sort((entry1, entry2) -> {
            int comparacionFrecuencia = entry2.getValue().compareTo(entry1.getValue());
            if (comparacionFrecuencia == 0) {
                return entry1.getKey().compareTo(entry2.getKey()); 
            }
            return comparacionFrecuencia; 
        });
        List<String> palabrasOrdenadas = new ArrayList<>();
        for (Map.Entry<String, Integer> entrada : listaDeEntradas) {
            palabrasOrdenadas.add(entrada.getKey());
        }
        return palabrasOrdenadas;
    }

}

