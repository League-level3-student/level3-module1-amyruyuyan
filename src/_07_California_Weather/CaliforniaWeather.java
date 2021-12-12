package _07_California_Weather;

import java.util.HashMap;

import javax.swing.JOptionPane;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 *          
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api 
 */

public class CaliforniaWeather {
    
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
	
	
	void chooseMethod() {
		String method = JOptionPane.showInputDialog("Would you like to search by city, weather condition, or temperature?");
		if(method.equals("city")) {
			new CaliforniaWeather().inputCity();
		}
		else if(method.equals("weather condition")) {
			new CaliforniaWeather().inputCondition();
		}
		else if(method.equals("temperature")) {
			new CaliforniaWeather().searchByTemperature();
		}
	}
	
    void inputCity() {
        String cityName = JOptionPane.showInputDialog("Which city do you want to find weather of?");
        
        // All city keys have the first letter capitalized of each word
        cityName = Utilities.capitalizeWords(cityName);
        WeatherData data1 = weatherData.get(cityName);
        
        if( data1 == null ) {
            System.out.println("Unable to find weather data for: " + cityName);
        } else {
            System.out.println(cityName + " is " + data1.weatherSummary + " with a temperature of " + data1.temperatureF + " F");
        }
    }
    
    void inputCondition() {
    	String weatherCondition = JOptionPane.showInputDialog("Input a weather condition to find cities with that current state:");
    	weatherCondition = Utilities.capitalizeWords(weatherCondition);
    	String cityConditions = ""; 
    	
    	for (String i: weatherData.keySet()) {
    		if (weatherData.get(i).weatherSummary.contains(weatherCondition)) {
    		cityConditions+=i + ", ";
    		}
    			}
    	System.out.println("cities w entith weather condition: " + weatherCondition + " are " + cityConditions);
    	}
    
    void searchByTemperature() {
    	String minCityTemperature = JOptionPane.showInputDialog("Input the minimum temperature:");
    	String maxCityTemperature = JOptionPane.showInputDialog("Input the maximum temperature:");
    	String cityTemperatures = "";
    	
    	Double minTemperature = Double.parseDouble(minCityTemperature);
    	Double maxTemperature = Double.parseDouble(maxCityTemperature);
    	
    	for(String j: weatherData.keySet()) {
    		if (weatherData.get(j).temperatureF >= minTemperature && weatherData.get(j).temperatureF <= maxTemperature) {
    			cityTemperatures+=j + ", ";
    		}
    	}
    	System.out.println("Cities with temperature range " + minCityTemperature + " - " + maxCityTemperature + " are: " + cityTemperatures);
    }

    }
    

