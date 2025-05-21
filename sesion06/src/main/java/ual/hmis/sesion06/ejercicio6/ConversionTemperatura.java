package ual.hmis.sesion06.ejercicio6;

// TODO: Auto-generated Javadoc
/**
 * The Class ConversionTemperatura.
 */
public class ConversionTemperatura {

	/**
	 * Convert temperature.
	 *
	 * @param temperature the temperature
	 * @param fromUnit the from unit
	 * @param toUnit the to unit
	 * @return the double
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