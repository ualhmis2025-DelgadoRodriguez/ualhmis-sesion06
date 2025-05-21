package ual.hmis.sesion06.ejercicio6;

/**
 * Clase ConversionTemperatura.
 */
public class ConversionTemperatura {

	/**
	 * Convert temperature.
	 *
	 * @param temperature temperatura
	 * @param fromUnit unidad de la que se parte
	 * @param toUnit unidad a la que se quiere pasar
	 * @return devuelve el resultado dependiendo de la situacion
	 */
	public double convertTemperature(double temperature, String fromUnit, String toUnit) {
	    if (fromUnit == null || toUnit == null) {
	        return Double.NaN;  
	    }

	    String from = fromUnit.trim().toLowerCase();
	    String to = toUnit.trim().toLowerCase();

	    if (from.equals(to)) {
	        return temperature;
	    }

	    switch (from) {
	        case "celsius":
	            switch (to) {
	                case "fahrenheit":
	                    return (temperature * 9.0 / 5.0) + 32;
	                case "kelvin":
	                    return temperature + 273.15;
	                default:
	                    return Double.NaN;  
	            }

	        case "fahrenheit":
	            switch (to) {
	                case "celsius":
	                    return (temperature - 32) * 5.0 / 9.0;
	                case "kelvin":
	                    return ((temperature - 32) * 5.0 / 9.0) + 273.15;
	                default:
	                    return Double.NaN;  
	            }

	        case "kelvin":
	            switch (to) {
	                case "celsius":
	                    return temperature - 273.15;
	                case "fahrenheit":
	                    return ((temperature - 273.15) * 9.0 / 5.0) + 32;
	                default:
	                    return Double.NaN; 
	            }

	        default:
	            return Double.NaN;  
	    }
	}
}