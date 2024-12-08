package com.example.petcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    private Context context;
    private List<Pet> petList;

    public PetAdapter(Context context, List<Pet> petList) {
        this.context = context;
        this.petList = petList;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        Pet pet = petList.get(position);
        holder.petName.setText(pet.getName());
        holder.petImage.setImageResource(pet.getImageResourceId());
        holder.adoptButton.setOnClickListener(v ->
                Toast.makeText(context, "Adopted: " + pet.getName(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        ImageView petImage;
        TextView petName;
        Button adoptButton;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.petImage);
            petName = itemView.findViewById(R.id.petName);
            adoptButton = itemView.findViewById(R.id.adoptButton);
        }
    }
}

