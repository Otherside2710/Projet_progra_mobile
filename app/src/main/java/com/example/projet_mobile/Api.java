package com.example.projet_mobile;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static String BASE_URL="https://gist.githubusercontent.com/Otherside2710/398b1ea7952908301563bc2459d5d5dc/raw/7fb43a69129584017d8d2e9c3bb00d8a41b90d0c/";

    private static Retrofit retrofit;
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
