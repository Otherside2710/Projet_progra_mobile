package com.example.projet_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Country> countryList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiInterface = Api.getClient().create(ApiInterface.class);

        Call<List<Country>> call = apiInterface.getCountry();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                countryList = response.body();

                Log.d("MainActivity", countryList.toString());

                recyclerAdapter = new RecyclerAdapter(getApplicationContext(),countryList);
                recyclerView.setAdapter(recyclerAdapter);

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("MainActivity", t.toString());

            }
        });
    }
}
