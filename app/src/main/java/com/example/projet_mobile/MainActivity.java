package com.example.projet_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Country> countryList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiInterface = Api.getClient().create(ApiInterface.class);

        Call<List<Country>> call = apiInterface.getCountry();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                countryList = response.body();

                Log.d("MainActivity", countryList.toString());

                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), countryList);
                recyclerView.setAdapter(recyclerAdapter);

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d("MainActivity", t.toString());

            }
        });
    }

    public void showList(final List<Country> input) {
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

       // mAdapter = new RecyclerAdapter(input);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new Clique(getApplicationContext(), recyclerView, new Clique.ClickListener() {
            public void onClick(View view, int position) {
                Country country = input.get(position);
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                intent.putExtra("abbreviation", country.getAbbreviation());
                startActivity(intent);
            }
        }));
    }

}