package com.example.projet_mobile;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("name")
    private String name;
    @SerializedName("capital")
    private String capital;

    public Country(String name, String capital){
        this.name = name;
        this.capital = capital;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital(){
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String toString() {
        return "Country(" + "name='" + name + '\"' + ", capital='" + capital + '\"' + ')';
    }
}
