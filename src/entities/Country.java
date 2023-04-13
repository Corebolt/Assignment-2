package entities;

public class Country {
    String code;
    String name;
    String continent;
    String region;
    Integer surfaceArea;
    Integer indepYear;
    Integer population;
    Integer lifeExpectancy;
    Integer GNP;
    Integer GNPOld;
    String localName;
    String governmentForm;
    String headOfState;
    Integer capital;
    String code2;

    //get/set code
    public String getCode(){
        return code;
    }

    public void setCode(String passedCode){
        this.code = passedCode;
    }

    //get/set name
    public String getName(){
        return name;
    }

    public void setName(String passedName){
        this.name = passedName;
    }

    //get/set continent
    public String getContinent(){
        return continent;
    }

    public void setContinent(String passedContinent){
        this.continent = passedContinent;
    }
    
    //get/set region
    public String getRegion(){
        return region;
    }

    public void setRegion(String passedRegion){
        this.region = passedRegion;
    }

    //get/set surfaceArea
    public Integer getSurfaceArea(){
        return surfaceArea;
    }

    public void setSurfaceArea(Integer passedSurfaceArea){
        this.surfaceArea = passedSurfaceArea;
    }

    //get/set indepYear
    public Integer getIndepYear(){
        return indepYear;
    }

    public void setIndepYear(Integer passedIndepYear){
        this.indepYear = passedIndepYear;
    }

    //get/set population

    public Integer getPopulation(){
        return population;
    }

    public void setPopulation(Integer passedPopulation){
        this.population = passedPopulation;
    }

    //get/set lifeExpectancy
    public Integer getLifeExpectancy(){
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Integer passedLifeExpectancy){
        this.lifeExpectancy = passedLifeExpectancy;
    }

    //get/set GNP
    public Integer getGNP(){
        return GNP;
    }

    public void setGNP(Integer passedGNP){
        this.GNP = passedGNP;
    }

    //get/set GNPOld
    public Integer getGNPOld(){
        return GNPOld;
    }

    public void setGNPOld(Integer passedGNPOld){
        this.GNPOld = passedGNPOld;
    }

    //get/set localName
    public String getLocalName(){
        return localName;
    }

    public void setLocalName(String passedLocalName){
        this.localName = passedLocalName;
    }

    //get/set governmentForm
    public String getGovernmentForm(){
        return governmentForm;
    }

    public void setGovernmentForm(String passedGovernmentForm){
        this.governmentForm = passedGovernmentForm;
    }

    //get/set headOfState
    public String getHeadOfState(){
        return headOfState;
    }

    public void setHeadOfState(String passedHeadOfState){
        this.headOfState = passedHeadOfState;
    }

    //get/set capital
    public Integer getCapital(){
        return capital;
    }

    public void setCapital(Integer passedCapital){
        this.capital = passedCapital;
    }

    //get/set code2
    public String getCode2(){
        return code2;
    }

    public void setCode2(String passedCode2){
        this.code2 = passedCode2;
    }

    @Override
    public String toString()
    {
        return "City [Code=" + code + ", Name=" + name + ", Continent="
        + continent + ", Region=" + region + ", SurfaceArea=" + surfaceArea + ", IndepYear=" + indepYear
        + ", Population=" + population + ", LifeExpectancy=" + lifeExpectancy + ", GNP=" + GNP
        + ", GNPOld=" + GNPOld + ", LocalName=" + localName + ", GovernmentForm=" + governmentForm
        + ", HeadOfState=" + headOfState + ", Capital=" + capital + ", Code2=" + code2 + "]";     
    }
}
