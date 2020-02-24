package com.grouproject.sem;

import java.sql.*;
import java.util.ArrayList;

// Authors of Project: Sabin Constantin Lungu, Taylor Courtney, Jonathan Sung and Sadeem Rashid
// Date of Last Modified: 7/02/2020
// Purpose of Application: To write SQL queries embedded in Java code to retrieve the data required for the requirements.
// Bugs?: Currently none

public class App {

    private Connection connection = null;
    private static ArrayList<String> listOfRegions = null; // Set to null initially

    public static void main(String[] args) {
        App app = new App();

        app.connect(); // Connect to the database
        listOfRegions = new ArrayList<String>();
        listOfRegions = app.extractRegions();


        //app.printCountries(app.getAllCountriesOrderByPopulation());
       // app.printCountries(app.getCountriesInContinentByLargestPopulation(com.grouproject.sem.Continent.NORTH_AMERICA));
       // app.getCountriesInRegionByLargestPopulation(listOfRegions.get(0));
        //app.printCountries(app.getTopNCountriesOrderByPopulation(3));

        // app.printCities(app.getAllCitiesInAContinent(Continent.NORTH_AMERICA));
        app.printCities(app.getAllCitiesInARegion(listOfRegions.get(0)));


        app.disconnect(); // Disconnect from DB
        System.out.println("End of program.");
    }

    private void printCountries(ArrayList<Country> countries) {
        for (Country country : countries) {

            System.out.println(country.toString());
        }
    }

    private void printCities(ArrayList<City> cities) {
        Object[][] cityTable = new String[cities.size()+1][];

        cityTable[0] = new String[] { "ID", "Name", "CountryCode", "District", "Population" };

        for (int i = 0; i < cities.size() - 1; i++) {

            cityTable[i + 1] = new String[] { String.valueOf(cities.get(i).getId()), cities.get(i).getName(), cities.get(i).getCountryCode(), cities.get(i).getDistrict(), Integer.toString(cities.get(i).getPopulation()) };
        }

        for (final Object[] row : cityTable) {
            System.out.format("%25s%25s%25s%25s%25s\n", row);
        }
    }

    private ArrayList<Country> getAllCountriesOrderByPopulation() { // Routine that gets the SQL query results for the first Requirement
        String query = "SELECT * FROM country ORDER BY country.Population DESC";
        return extractCountryData(query);
    }

    private ArrayList<Country> getCountriesInContinentByLargestPopulation(Continent continent) { // Requirement 2 code
        String myQuery = "SELECT * FROM country "
                + " WHERE Continent = '" + continent.getContinent()
                + "' ORDER BY country.Population DESC ";
        return extractCountryData(myQuery);
    }

    private ArrayList<Country> getTopNCountriesOrderByPopulation(int n) { // Routine that gets the SQL query results for the first Requirement
        String myQuery = "SELECT * "
                + "FROM country "
                + "ORDER BY country.Population DESC "
                + "LIMIT " + n;
        return extractCountryData(myQuery);
    }

    private ArrayList<Country> getCountriesInRegionByLargestPopulation(String region) { // Requirement 2 code
        String myQuery = "SELECT * FROM country "
                + " WHERE Region = '" + region
                + "' ORDER BY country.Population DESC ";

        return extractCountryData(myQuery);
    }

    private ArrayList<City> getAllCitiesInWorld() {
        String query = "SELECT * FROM city ORDER BY city.population DESC;";
        return extractCityData(query);
    }

    private ArrayList<City> getAllCitiesInAContinent(Continent continent) {
        String query = "SELECT * FROM city" +
                " INNER JOIN country ON (city.CountryCode = country.code)" +
                " WHERE Continent = '" + continent.getContinent() +
                "' ORDER BY city.population DESC ";
        return extractCityData(query);
    }

    private ArrayList<City> getAllCitiesInARegion(String theRegion) { // This routine gets all the cities in a region by passing in an input region from the user.
        String query = "SELECT * FROM city" +
                " INNER JOIN country ON (city.CountryCode = country.code)" +
                " WHERE region = '" + theRegion +
                "' ORDER BY city.population DESC "; // The query to get it.

        return extractCityData(query);
    }

    private ArrayList<Country> extractCountryData(String query) {
        try {

            ArrayList<Country> temp_countries = new ArrayList<Country>();
            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                Country country = new Country(set.getString("Code"), set.getString("Name"), set.getString("Continent"),
                        set.getString("Region"), set.getFloat("SurfaceArea"), set.getInt("IndepYear"),
                        set.getInt("Population"), set.getFloat("LifeExpectancy"), set.getFloat("GNP"),

                        set.getFloat("GNPOld"), set.getString("LocalName"), set.getString("GovernmentForm"),
                        set.getString("HeadOfState"), set.getInt("Capital"), set.getString("Code2"));
                temp_countries.add(country);

                //System.out.println(country.toString()); // Print all the data out
            }
            return temp_countries;

        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
            return null;
        }
    }

    private ArrayList<City> extractCityData(String query) { // Extracts the city data by using an SQL query
        try {
            ArrayList<City> tempCities = new ArrayList<City>(); // A list of cities to get stored.

            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);

            while (set.next()) { // Loop over the next set
                 City city = new City(set.getInt("ID"), set.getString("Name"),
                         set.getString("CountryCode"),
                         set.getString("District"),
                         set.getInt("Population"));

                 tempCities.add(city);
             }

             return tempCities;

        } catch (SQLException exc) {

            exc.printStackTrace();

            System.out.println(exc.getMessage());

        }

        return null;
    }

    private ArrayList<String> extractRegions() { // Returns a list of regions
        ArrayList<String> temp_regions = new ArrayList<String>();

        try {

            String myQuery = "SELECT DISTINCT Region FROM country "; // SQL query to get the region
            Statement stmt = connection.createStatement(); // Create a connection statement
            ResultSet set = stmt.executeQuery(myQuery);

            while (set.next()) {
                String region = set.getString("Region");
                temp_regions.add(region);
            }

            return temp_regions;

        } catch (SQLException exc) { // Catch exception
            System.out.println(exc.toString());
            return null;
        }
    }

    private void disconnect() { // Routine to disconnect from the DB
        if (connection != null) {
            try {

                connection.close();
            } catch (Exception e) {
                System.out.println("Error connecting to db");
            }
        }
    }

    private void connect() { // Routine to connect to the DB
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Could not load SQL Driver");
            System.exit(-1);

        }

        int retries = 100;

        for (int i = 0; i < retries; i++) {
            System.out.println("Connecting to DB...");

            try {
                Thread.sleep(1000);
                connection = DriverManager.getConnection("jdbc:mysql://dbb:3306/world?useSSL=false", "root", "example");
                System.out.println("Connect Success");
                break;

            } catch (SQLException exc) {

                System.out.println("Failed to connect to DB. Attempt : " + i);

            } catch (InterruptedException e) {

                System.out.println("Thread failed");
            }

        }
    }
}