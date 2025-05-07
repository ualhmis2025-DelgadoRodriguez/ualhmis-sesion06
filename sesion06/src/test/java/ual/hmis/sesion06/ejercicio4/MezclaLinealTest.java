package ual.hmis.sesion06.ejercicio4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.*;
import java.util.stream.Collectors;

class MezclaLinealTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/ual/hmis/sesion06/ejercicio4/CSVEjercicio4.csv", numLinesToSkip = 0)
    void testMezclar(String lista1, String lista2, String expectedResult) {
        // Convertir las cadenas de entrada a listas de enteros
        List<Integer> lista1Parsed = parseStringToList(lista1);
        List<Integer> lista2Parsed = parseStringToList(lista2);
        List<Integer> expectedParsed = parseStringToList(expectedResult);
        MezclaLineal mezclaLineal = new MezclaLineal();
        List<Integer> resultado = mezclaLineal.mezclar(lista1Parsed, lista2Parsed);
        assertEquals(expectedParsed, resultado);
    }

    private List<Integer> parseStringToList(String str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.stream(str.split(","))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }
}
