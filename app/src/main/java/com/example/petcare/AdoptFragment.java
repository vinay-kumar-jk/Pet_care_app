package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdoptFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adopt, container, false);

        // RecyclerView setup
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Create a list of pets
        List<Pet> petList = new ArrayList<>();
        petList.add(new Pet("Buddy", R.drawable.pet1));
        petList.add(new Pet("Lucy", R.drawable.pet2));
        petList.add(new Pet("Charlie", R.drawable.pet3));
        petList.add(new Pet("Max", R.drawable.pet4));
        petList.add(new Pet("Bella", R.drawable.pet5));
        petList.add(new Pet("Oliver", R.drawable.pet6));
        petList.add(new Pet("Daisy", R.drawable.pet7));


        // Set adapter
        PetAdapter adapter = new PetAdapter(getContext(), petList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}

