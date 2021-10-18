package com.example.ListViewCountries;

public class Country {
    private String countryCode;
    private String countryName;
    private String countryCapital;
    private long countryPopulation;
    private String countryIso3;

    public Country(String countryCode, String countryName, String countryCapital, long countryPopulation, String countryIso3) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.countryPopulation = countryPopulation;
        this.countryIso3 = countryIso3;
    }

}
