package com.example.projet_mobile;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {

    private Context context;
    private List<Country> countryList;


    public RecyclerAdapter(Context context, List<Country> countryList){
        this.context = context;
        this.countryList = countryList;
    }

    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout,viewGroup, false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder( RecyclerAdapter.MyviewHolder myviewHolder, int i) {

        myviewHolder.textViewCountryName.setText(countryList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }


    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView textViewCountryName;
        public MyviewHolder( View itemView) {
            super(itemView);

            textViewCountryName = (TextView)itemView.findViewById(R.id.textViewCountryName);
        }
    }
}
