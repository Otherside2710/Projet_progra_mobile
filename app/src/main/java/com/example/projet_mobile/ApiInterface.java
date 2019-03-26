package com.example.projet_mobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("Country/")
    abstract Call<List<Country>> getCountry();
}
