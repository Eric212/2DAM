package com.example.paiseslistview;

public class Pais {
    private String codigoPais;
    private String pais;
    private String capital;
    private long poblacion;
    private String iso3;

    public Pais(String codigoPais,String pais, String capital, long poblacion, String iso3) {
        this.codigoPais=codigoPais;
        this.pais = pais;
        this.capital = capital;
        this.poblacion = poblacion;
        this.iso3 = iso3;
    }

    public String getPais() {
        return pais;
    }

    public String getCapital() {
        return capital;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public String getIso3() {
        return iso3;
    }
}
