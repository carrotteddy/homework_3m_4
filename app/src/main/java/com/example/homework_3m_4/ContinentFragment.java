package com.example.homework_3m_4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ContinentFragment extends Fragment implements OnItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<Continent> continentArrayList;
    private int[] continentImageId;
    private String[] continentNames;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_continent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        recyclerView = view.findViewById(R.id.rv_continent);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ContinentAdapter adapter = new ContinentAdapter(getContext(), continentArrayList, this);
        recyclerView.setAdapter(adapter);

    }

    public void loadData() {
        continentArrayList = new ArrayList<>();
        continentNames = new String[]{
                "Eurasia", "Africa", "North America", "South America","Australia"
        };
        continentImageId = new int[]{
          R.drawable.eurasia,R.drawable.africa,
                R.drawable.north_america,R.drawable.south_america,R.drawable.austalia
        };
        for (int i = 0; i < continentNames.length; i++) {
            Continent continent = new Continent(continentNames[i], continentImageId[i]);
            continentArrayList.add(continent);
        }
    }


    @Override
    public void OnItemClick(int position) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        CountryFragment countryFragment = new CountryFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("continent", position);
        countryFragment.setArguments(bundle);
        transaction.replace(R.id.container, countryFragment).addToBackStack(null).;
        countryFragment.loadData(position);
    }
}