/*
 * Lalithsai Posam
 * CityInfo.java
 * This program processes a file and reads and writes to the cities.dat
 * file to display information about specific cities in each country. 
 * It contains two classes: The city class and the city info class which
 * contains the main method
 */
 
// Import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;

// This is the city class 
class City {
	private String country;
	private String name;
	private int population;
	
	// No arg constructor
	public City() {
		this("", "", 0);
	}
	
	// Three arg constructor
	public City(String country, String name, int population) {
		this.country = country;
		this.name = name;
		this.population = population;
	}
	
	// Returns the country code
	public String getCountry () {
		return country;
	}
	
	// Returns the name of the city
	public String getCityName () {
		return name;
	}
	
	// Retusn the population
	public int getPopulation () {
		return population;
	}
	
	// Sets the population
	public void setPopulation (int population) {
		this.population = population;
	}
	
	// The City class' toString method
	public String toString () {
        return String.format("%s:%s:%d", country, name, population);
	}
}

// This is the class that reads and writes a new file containing the cities.
public class CityInfo {
	
	// Reads the cities.dat file
	public static ArrayList <City> readCityFile (String fileName) {
		// Creates new array list and file with filename
		ArrayList<City> cityList = new ArrayList<City>();
		File cityFile = new File(fileName);
		
		// Try and catch block
		try {
			
			// Program attempts to open the file and split each line
			Scanner inFile = new Scanner(cityFile);
			
			while (inFile.hasNextLine()) {
				String city = inFile.nextLine();
				String[] cityInfo = city.split(";");
				
				// Checks if the arraylist is three entries long
				if (cityInfo.length != 3) {
					System.out.printf("\"%s\" does not have three entries.\n", 
					city);
				}
				
				else {
					// Attempts to add the entries to the array list
					try {
						cityList.add(new City(cityInfo[0], cityInfo[1], 
						Integer.valueOf(cityInfo[2])));
					}
					
					// Catches the NumberFormatException exception and
					// prints error message
					catch (NumberFormatException ex) {
                        System.out.printf("\"%s\" does not have a number" + 
										  " on it.\n", city);
					}
				}	
			}
			inFile.close();
		}
		
		// Catches the NumberFormatException exception and prints error message
		catch (FileNotFoundException ex) {
            System.out.printf("Cannot open file %s.\n", fileName);
        }
        
        // Catches all other exceptions and prints general error message
        catch (Exception ex) {
            System.out.printf("Error processing %s.\n", fileName);
            cityList.clear();
        }
        
        return cityList;
    }
    
    // Calculates the number of cities and average population based on
    // country code.
    public static int statistics(String countryCode, ArrayList<City> cityList) {
		int numberOfCities = 0;
		int totalPopulation = 0;
		
		for (City city: cityList) {
			if (city.getCountry().equals(countryCode)) {
				numberOfCities++;
				totalPopulation += city.getPopulation();
			}
		}
		
		if (numberOfCities > 0) {
			System.out.printf("Number of cities in %s: %d\n",
                countryCode, numberOfCities);
            System.out.printf("Average population is %,.0f.\n",
                (double) totalPopulation / numberOfCities);
		}
		
		else {
			System.out.printf("No cities found in %s \n", countryCode);
		}
		
		return numberOfCities;
		
	}
	
	// Creates a new file nameed "countrycode.dat" and writes new 
	// information to the file
	public static void writeCountryFile(String countryCode, 
										ArrayList<City> cityList) {    
		String fileName = countryCode + ".dat";
		File cities = new File(fileName);
		
		// Tries to write infomration to the file
		try (PrintWriter output = new PrintWriter(cities)) {
			
			for (City city: cityList) {
				if (city.getCountry().equals(countryCode)) {
					output.write(city.toString() + "\n");
				}
			}
			
			System.out.printf("File %s written successfully.\n", fileName);
		}
		
		// Catches IOException and prints error message
		catch (IOException ex) {
			System.out.printf("There is an error writing %s\n", fileName);
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main (String[] args) {
		System.out.println("The file is being processed...");
		ArrayList<City> cityList = readCityFile("citylist.dat");
		
		if (cityList.size() > 0) {
			Scanner input = new Scanner(System.in);
			boolean finished = false;
			System.out.println();
		
			while (!finished) {
				System.out.print("Enter a country code, or press ENTER" +  
								 " to quit: ");
				String countryCode = input.nextLine();
				
				if (!countryCode.equals("")) {
					countryCode = countryCode.toUpperCase();
					int numberOfCities = statistics(countryCode, cityList);
					
					if (numberOfCities > 0) {
						writeCountryFile(countryCode, cityList);
					}
				}
				
				else {
					finished = true;
				}
			}
		}
	}
}

