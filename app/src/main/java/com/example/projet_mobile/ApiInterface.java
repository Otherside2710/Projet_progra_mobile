package com.example.projet_mobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("7fb43a69129584017d8d2e9c3bb00d8a41b90d0c/")
    Call<List<Country>> getCountry();
}
