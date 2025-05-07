package ual.hmis.sesion06.ejercicio6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTemperaturaTest {

    ConversionTemperatura conversion = new ConversionTemperatura();

    @ParameterizedTest
    @CsvSource({
        "0, celsius, fahrenheit, 32.0",
        "100, celsius, fahrenheit, 212.0",
        "0, celsius, kelvin, 273.15",
        "100, celsius, kelvin, 373.15",

        "32, fahrenheit, celsius, 0.0",
        "212, fahrenheit, celsius, 100.0",
        "32, fahrenheit, kelvin, 273.15",
        "212, fahrenheit, kelvin, 373.15",

        "273.15, kelvin, celsius, 0.0",
        "373.15, kelvin, celsius, 100.0",
        "273.15, kelvin, fahrenheit, 32.0",
        "373.15, kelvin, fahrenheit, 212.0",

        "25, celsius, celsius, 25.0",
        "77, fahrenheit, fahrenheit, 77.0",
        "300, kelvin, kelvin, 300.0"
    })
    void testValidConversions(double inputTemp, String fromUnit, String toUnit, double expected) {
        double result = conversion.convertTemperature(inputTemp, fromUnit, toUnit);
        assertEquals(expected, result, 0.01);
    }

    @ParameterizedTest
    @CsvSource({
        "100, invalid, celsius",        
        "100, celsius, invalid",                 
        "100, kelvin, celsiuss",         
        "100, null, celsius",           
        "100, celsius, null",            
        "100, fahrenheitt, kelvin",      
        "100, fahrenheit, kelvinn",      
        "100, null, fahrenheit",         
        "100, fahrenheit, null"          
    })
    void testInvalidOrNullUnits(double temp, String fromUnit, String toUnit) {
        String from = "null".equals(fromUnit) ? null : fromUnit;
        String to = "null".equals(toUnit) ? null : toUnit;

        double result = conversion.convertTemperature(temp, from, to);
        assertTrue(Double.isNaN(result), 
            () -> "Esperado Double.NaN para unidades inválidas: from=" + from + ", to=" + to);
    }
}