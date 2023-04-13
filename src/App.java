import java.sql.*;
import java.util.List;
import daos.CityDao;
import daos.CountryDao;
import daos.LanguageDao;
import entities.City;
import entities.Country;
import entities.Database;
import entities.Language;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        List<Language> languageList;
        List<City> cityList;

        //connect to database
        try (Connection connection = Database.getDatabaseConnection();
        Statement statement = connection.createStatement();){
            
        //CityDao
        CityDao cityDao = new CityDao(connection);
        cityList = cityDao.findAll();

        //LanguageDao
        LanguageDao languageDao = new LanguageDao(connection);
        languageList = languageDao.findAll();

        System.out.println("Cities printed: ");
        for(City city: cityList) {
            System.out.println(city);
        }
        System.out.println("Languages printed: ");
        for(Language language: languageList){
            System.out.println(language);
        }

        //Insert a new city
        City insertCity = new City();
        insertCity.setCountryCode("CAN");
        insertCity.setDistrict("King");
        insertCity.setName("Kingston");
        insertCity.setPopulation(136685);

        //Using findById and then executing the update
        //Update existing city
        City updateCity = new City();
        updateCity = cityDao.findById(4075);        
        updateCity.setPopulation(10000);        
        Boolean success = cityDao.update(updateCity);
        System.out.println(success);

        //Delete existing city
        Boolean succeeded = cityDao.delete(4085);
        System.out.println(succeeded);
        cityDao.insert(insertCity);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM country");        
        while(resultSet.next())
        {
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        }
        catch(SQLException ex)
        {
            System.err.println("Exception: " + ex.getMessage());
        }

        /////////////////// Assignment 2 Part 1 ///////////////////////////////////
        //Seperate part 1 and previous code
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Assignment 2 Part 1");

        List<Country> countryList;

        //connect to database
        try (Connection connection = Database.getDatabaseConnection();
        Statement statement = connection.createStatement();){
        
        //countryDao
        CountryDao countryDao = new CountryDao(connection);
        countryList = countryDao.findAll();

        System.out.println("Countries printed: ");
        for(Country country: countryList) {
            System.out.println(country);
        }

         //Insert a new country
        Country insertCountry = new Country();
        insertCountry.setCode("RAF");
        insertCountry.setName("Raffu");
        insertCountry.setContinent("Africa");
        insertCountry.setRegion("Central Africa");
        insertCountry.setSurfaceArea(2);
        insertCountry.setIndepYear(1);
        insertCountry.setPopulation(5);
        insertCountry.setLifeExpectancy(100);
        insertCountry.setGNP(6);
        insertCountry.setGNPOld(4);
        insertCountry.setLocalName("Rafraf");
        insertCountry.setGovernmentForm("Monarchy");
        insertCountry.setHeadOfState("Jeff");
        insertCountry.setCapital(9);
        insertCountry.setCode2("RA");         

        //Using findById and then executing the update
        //Update a country
        Country updateCountry = new Country();
        updateCountry = countryDao.findById("RAF");
        
        updateCountry.setPopulation(10000);
        
        Boolean success = countryDao.update(updateCountry);
        System.out.println("country update = " + success);

        //Delete a country
        Boolean succeeded = countryDao.delete("REF");
        System.out.println("country delete = " + succeeded);
        }

        //////////////////// Assignment 2 Part 2 ////////////////////////
        //seperate part 2 from part 1
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Assignment 2 Part 2");

        //connect to database
        try (Connection connection = Database.getDatabaseConnection();
        Statement statement = connection.createStatement();)
        {
        // find any city by city name
        City findCityName = new City();
        CityDao cityDao = new CityDao(connection);
        findCityName = cityDao.findByName("Kabul");
        
        System.out.println("Find city by name: " + findCityName);

        //find all cities from a given country by country code
        cityList = cityDao.findAllInCountry("USA");

        System.out.println("Find all cities in a given country: " + cityList);

        //find all cities with population greater then 1,000,000
        cityList = cityDao.findAllLargePopulation();

        System.out.println("All cities over 1,000,000 population: " + cityList);

        //find a country by country name
        Country findCountryName = new Country();
        CountryDao countryDao = new CountryDao(connection);
        findCountryName = countryDao.findByName("Canada");

        System.out.println("Find country by name: " + findCountryName);

        //find all country in a given region by searching region
        countryList = countryDao.findAllInRegion("North America");

        System.out.println("Find all countries in a region: " + countryList);
        }
    }
}
