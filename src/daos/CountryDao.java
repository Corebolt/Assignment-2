package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Country;

public class CountryDao implements Dao<Country, String>{
    Connection connection;

    public CountryDao(Connection connection){
        this.connection = connection;
    }

    public List<Country> findAll()
    {
        List<Country> countries = new ArrayList<>();

        try(Statement statement = connection.createStatement())
        {
            ResultSet result = statement.executeQuery("SELECT * FROM country");
            while(result.next())
            {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getInt("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getInt("LifeExpectancy"));
                country.setGNP(result.getInt("GNP"));
                country.setGNPOld(result.getInt("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
                countries.add(country);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return countries;
    }
    
    public Boolean update(Country country)
    {
        Boolean success = true;
        String update = "UPDATE country SET Population=? WHERE Code=?";

        try(PreparedStatement ps = connection.prepareStatement(update);)
        {
            ps.setInt(1, country.getPopulation());
            ps.setString(2, country.getCode());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }

    public Country findById(String code)
    {
        Country country = new Country();
        String select = "SELECT * FROM country WHERE Code=?";
        try(PreparedStatement ps = connection.prepareStatement(select);)
        {
            ps.setString(1, code);
            ResultSet result = ps.executeQuery();

            if(result.next())
            {
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getInt("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getInt("LifeExpectancy"));
                country.setGNP(result.getInt("GNP"));
                country.setGNPOld(result.getInt("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return country;
    }

    public Boolean delete(String code)
    {
        Boolean success = false;
        String delete = "DELETE FROM country WHERE Code=?";

        try(PreparedStatement ps = connection.prepareStatement(delete))
        {
            ps.setString(1, code);

            if(ps.executeUpdate() != 0)
            {
                success = true;
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return success;
    }

    public void insert(Country country)
    {
        try(Statement statement = connection.createStatement())
        {
            String insert = "INSERT INTO country VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, country.getCode());
            ps.setString(2, country.getName());
            ps.setString(3, country.getContinent());
            ps.setString(4, country.getRegion());
            ps.setInt(5, country.getSurfaceArea());
            ps.setInt(6, country.getIndepYear());
            ps.setInt(7, country.getPopulation());
            ps.setInt(8, country.getLifeExpectancy());
            ps.setInt(9, country.getGNP());
            ps.setInt(10, country.getGNPOld());
            ps.setString(11, country.getLocalName());
            ps.setString(12, country.getGovernmentForm());
            ps.setString(13, country.getHeadOfState());
            ps.setInt(14, country.getCapital());
            ps.setString(15, country.getCode2());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next())
            {
                country.setCode(keys.getString(1));
            }

        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    ///////////////// Assignment 2 part 2 //////////////////

    //find country by country name
    public Country findByName(String cityName)
    {
        Country country = new Country();
        String select = "SELECT * FROM country WHERE name=?";

        try(PreparedStatement ps = connection.prepareStatement(select);)
        {
            ps.setString(1, cityName);
            ResultSet result = ps.executeQuery();
            if(result.next())
            {
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getInt("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getInt("LifeExpectancy"));
                country.setGNP(result.getInt("GNP"));
                country.setGNPOld(result.getInt("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return country;
    }

    //find all cities in a given country (by country code)
    public List<Country> findAllInRegion(String region)
    {
        List<Country> countries = new ArrayList<>();
        String select = "SELECT * FROM country WHERE Region =?";
        try(PreparedStatement ps = connection.prepareStatement(select))
        {
            ps.setString(1, region);
            ResultSet result = ps.executeQuery();

            while(result.next())
            {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setContinent(result.getString("Continent"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getInt("SurfaceArea"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setPopulation(result.getInt("Population"));
                country.setLifeExpectancy(result.getInt("LifeExpectancy"));
                country.setGNP(result.getInt("GNP"));
                country.setGNPOld(result.getInt("GNPOld"));
                country.setLocalName(result.getString("LocalName"));
                country.setGovernmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
                countries.add(country);
            }            
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return countries;
    }         
}
