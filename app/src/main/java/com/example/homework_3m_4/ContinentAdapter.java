package com.example.homework_3m_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter <ContinentAdapter.ContinentViewHolder> {
    Context context;
    ArrayList<Continent> continentArrayList;
    private OnItemClickListener listener;

    public ContinentAdapter(Context context, ArrayList<Continent> continentArrayList, OnItemClickListener listener) {
        this.context = context;
        this.continentArrayList = continentArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ContinentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        Continent continent = continentArrayList.get(position);
        holder.tv_name.setText(continent.getName());
        holder.img_continent.setImageResource(continent.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                if (clickedPosition != RecyclerView.NO_POSITION && listener != null) {
                    listener.OnItemClick(clickedPosition);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return continentArrayList.size();
    }

    public static class ContinentViewHolder extends RecyclerView.ViewHolder {
        ImageView img_continent;
        TextView tv_name;

        public ContinentViewHolder(@NonNull View itemView) {
            super(itemView);
            img_continent = itemView.findViewById(R.id.img_continent);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
