package ual.hmis.sesion06.ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class Ejercicio3Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/ual/hmis/sesion06/ejercicio3/testdata.csv", numLinesToSkip = 0)
    void testEnmascararPassword(String input, String expected) {
        Ejercicio3 ej3 = new Ejercicio3();
        String resultado = ej3.enmascararPassword(input);
        assertEquals(expected, resultado);
    }
}