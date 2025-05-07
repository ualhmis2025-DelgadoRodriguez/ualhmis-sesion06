package ual.hmis.sesion06.ejercicio5;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ContadorDePalabrasTest {

    private static final String TEMP_DIR = "src/test/java/ual/hmis/sesion06/ejercicio5/";

    private void crearArchivoDePrueba(String nombreArchivo, String contenido) throws IOException {
        if (contenido == null) {
            contenido = "";
        }
        
        File archivo = new File(TEMP_DIR + nombreArchivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(contenido);
        }
    }

    @Test
    void testPalabrasConEspacios() throws IOException {
        String contenido = "   manzana    pera   ";  

        crearArchivoDePrueba("testConEspacios.txt", contenido);

        ContadorDePalabras contador = new ContadorDePalabras();
        List<String> palabrasAlfabeticas = contador.obtenerPalabrasAlfabeticamente(TEMP_DIR + "testConEspacios.txt");

        assertEquals(Arrays.asList("manzana", "pera"), palabrasAlfabeticas);  
    }

    @Test
    void testProcesarArchivoConExcepcion() {
        ContadorDePalabras contador = new ContadorDePalabras();
        Map<String, Integer> resultado = contador.procesarArchivo("archivoInexistente.txt");
        assertTrue(resultado.isEmpty());
    }

    @Test
    void testPalabraNull() throws IOException {
        crearArchivoDePrueba("testNull.txt", null);

        ContadorDePalabras contador = new ContadorDePalabras();
        List<String> palabrasAlfabeticas = contador.obtenerPalabrasAlfabeticamente(TEMP_DIR + "testNull.txt");

        assertTrue(palabrasAlfabeticas.isEmpty()); 
    }

    @Test
    void testProcesarArchivoConPalabras() throws IOException {
        String contenido = "manzana pera manzana uva naranja pera";
        crearArchivoDePrueba("test1.txt", contenido);

        ContadorDePalabras contador = new ContadorDePalabras();
        Map<String, Integer> resultado = contador.procesarArchivo(TEMP_DIR + "test1.txt");
        assertEquals(4, resultado.size());
        assertEquals(2, resultado.get("manzana"));
        assertEquals(2, resultado.get("pera"));
        assertEquals(1, resultado.get("uva"));
        assertEquals(1, resultado.get("naranja"));
    }

    @Test
    void testObtenerPalabrasAlfabeticamente() throws IOException {
        String contenido = "manzana pera manzana uva naranja pera";
        crearArchivoDePrueba("test1.txt", contenido);
        ContadorDePalabras contador = new ContadorDePalabras();
        List<String> palabrasAlfabeticas = contador.obtenerPalabrasAlfabeticamente(TEMP_DIR + "test1.txt");
        assertEquals(Arrays.asList("manzana", "naranja", "pera", "uva"), palabrasAlfabeticas);
    }

    @Test
    void testObtenerPalabrasPorOcurrencias() throws IOException {
        String contenido = "manzana pera manzana uva naranja pera pera";
        crearArchivoDePrueba("test2.txt", contenido);
        ContadorDePalabras contador = new ContadorDePalabras();
        List<String> palabrasPorOcurrencias = contador.obtenerPalabrasPorOcurrencias(TEMP_DIR + "test2.txt");
        assertEquals(Arrays.asList("pera", "manzana", "naranja", "uva"), palabrasPorOcurrencias);
    }

    @Test
    void testArchivoVacio() throws IOException {
        crearArchivoDePrueba("testVacio.txt", "");
        ContadorDePalabras contador = new ContadorDePalabras();
        List<String> palabrasAlfabeticas = contador.obtenerPalabrasAlfabeticamente(TEMP_DIR + "testVacio.txt");
        assertTrue(palabrasAlfabeticas.isEmpty());
    }

    @Test
    void testPalabrasUnicas() throws IOException {
        String contenido = "apple orange banana";
        crearArchivoDePrueba("testUnicas.txt", contenido);
        ContadorDePalabras contador = new ContadorDePalabras();
        List<String> palabrasAlfabeticas = contador.obtenerPalabrasAlfabeticamente(TEMP_DIR + "testUnicas.txt");
        assertEquals(Arrays.asList("apple", "banana", "orange"), palabrasAlfabeticas);
    }

    @Test
    void testPalabrasRepetidas() throws IOException {
        String contenido = "apple apple banana banana apple orange";
        crearArchivoDePrueba("testRepetidas.txt", contenido);
        ContadorDePalabras contador = new ContadorDePalabras();
        List<String> palabrasPorOcurrencias = contador.obtenerPalabrasPorOcurrencias(TEMP_DIR + "testRepetidas.txt");
        assertEquals(Arrays.asList("apple", "banana", "orange"), palabrasPorOcurrencias);
    }

    @Test
    void testPalabrasConCaracteresEspeciales() throws IOException {
        String contenido = "apple, orange! banana? banana apple.";
        crearArchivoDePrueba("testEspeciales.txt", contenido);
        ContadorDePalabras contador = new ContadorDePalabras();
        List<String> palabrasAlfabeticas = contador.obtenerPalabrasAlfabeticamente(TEMP_DIR + "testEspeciales.txt");
        assertEquals(Arrays.asList("apple", "banana", "orange"), palabrasAlfabeticas);
    }

    @Test
    void testPalabrasConMayusculas() throws IOException {
        String contenido = "Apple orange Banana banana Apple";
        crearArchivoDePrueba("testMayusculas.txt", contenido);
        ContadorDePalabras contador = new ContadorDePalabras();
        List<String> palabrasAlfabeticas = contador.obtenerPalabrasAlfabeticamente(TEMP_DIR + "testMayusculas.txt");
        assertEquals(Arrays.asList("apple", "banana", "orange"), palabrasAlfabeticas);
    }
}
