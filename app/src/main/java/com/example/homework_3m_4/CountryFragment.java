package com.example.homework_3m_4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CountryFragment extends Fragment {
    ArrayList<Country> countryArrayList;
    private String[] countryNames;
    private String[] countryFlags;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int selectedPosition = getArguments().getInt("continent", -1);
        if(selectedPosition != -1) {
            loadData(selectedPosition);

            recyclerView = view.findViewById(R.id.rv_country);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            CountryAdapter adapter = new CountryAdapter(countryArrayList, getContext());
            recyclerView.setAdapter(adapter);
        } else {
            Log.d("Dan", "-1 ");
        }

    }

    protected void loadData(int selectedPosition) {
        countryArrayList = new ArrayList<>();
        if (selectedPosition == 0) {
            countryFlags = new String[]{"https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
            "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
                    "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg","https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
            "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg", "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg"};
            countryNames = new String[]{"Russia", "China", "India", "Turkey", "Japan", "South Korea"};

        } else if (selectedPosition == 1) {
            countryNames = new String[]{"Nigeria", "Egypt", "South Africa", "Kenya"};
            countryFlags = new String[]{"https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
                    "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
                    "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
                    "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg"};

        } else if (selectedPosition == 2) {
            countryNames = new String[]{"USA", "Canada", "Mexico"};
            countryFlags = new String[]{"https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
            "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
            "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg"};

        } else if (selectedPosition == 3) {
            countryNames = new String[]{"Brazil", "Argentina", "Colombia"};
            countryFlags = new String[]{"https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
                    "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
                    "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg"};

        } else if (selectedPosition == 4) {
            countryNames = new String[]{"Australia", "New Zealand"};
            countryFlags = new String[]{"https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg",
                    "https://catherineasquithgallery.com/uploads/posts/2021-03/1614846271_41-p-fon-flag-rossii-46.jpg"};
        }

        for (int i = 0; i < countryNames.length; i++) {
            Country country = new Country(countryFlags[i], countryNames[i]);
            countryArrayList.add(country);
        }
    }
}
