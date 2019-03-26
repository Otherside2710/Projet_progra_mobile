package com.example.projet_mobile;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("name")
    private String name;
    @SerializedName(" abbreviation")
    private String abbreviation;

    public Country(String name, String  abbreviation){
        this.name = name;
        this. abbreviation = abbreviation;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String  abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String toString() {
        return "States(" + "name='" + name + '\"' + ", abbreviation='" +  abbreviation + '\'' + ')';
    }
}
