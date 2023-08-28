package com.example.homework_3m_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    ArrayList<Country> countryArrayList;
    Context context;

    public CountryAdapter(ArrayList<Country> countryArrayList, Context context) {
        this.countryArrayList = countryArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_country, parent,false );
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryArrayList.get(position);
        holder.country_name.setText(country.getName());
        Glide.with(context).load(country.getImageURI()).into(holder.img_flag);
    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder{
        ImageView img_flag;
        TextView country_name;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            img_flag = itemView.findViewById(R.id.img_country);
            country_name = itemView.findViewById(R.id.tv_country_name);
        }
    }

}
