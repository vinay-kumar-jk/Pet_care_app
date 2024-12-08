package com.example.petcare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Store extends Fragment {

    private RecyclerView productsRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        productsRecyclerView = view.findViewById(R.id.productsRecyclerView);

        // Prepare product list
        List<Product> products = new ArrayList<>();
        products.add(new Product("Dog Food", R.drawable.dog_food));
        products.add(new Product("Cat Food", R.drawable.cat_food));
        products.add(new Product("Dog Shampoo", R.drawable.dog_shampoo));
        products.add(new Product("Training pad", R.drawable.training_pads));
        products.add(new Product("Pet lesh", R.drawable.pet_leash));
        products.add(new Product("Fish Food", R.drawable.fish_food));
        products.add(new Product("Treat ball", R.drawable.treat_ball));
        products.add(new Product("Harnes", R.drawable.harnes));
        products.add(new Product("Dog Chew Bone", R.drawable.dog_chew));
        products.add(new Product("Pet Toys", R.drawable.pet_toys_combo));



        // Add more products as needed

        // Set up adapter and RecyclerView
        ProductAdapter adapter = new ProductAdapter(requireContext(), products, product -> {
            // Handle Add to Cart
            Toast.makeText(requireContext(), product.getName() + " added to cart", Toast.LENGTH_SHORT).show();
        });

        productsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        productsRecyclerView.setAdapter(adapter);
    }
}
