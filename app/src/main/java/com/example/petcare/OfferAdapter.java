package com.example.petcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petcare.R;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    private Context context;
    private List<Integer> offerImages;

    public OfferAdapter(Context context, List<Integer> offerImages) {
        this.context = context;
        this.offerImages = offerImages;
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_offer, parent, false);
        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        holder.imageOffer.setImageResource(offerImages.get(position));
    }

    @Override
    public int getItemCount() {
        return offerImages.size();
    }

    public static class OfferViewHolder extends RecyclerView.ViewHolder {
        ImageView imageOffer;

        public OfferViewHolder(@NonNull View itemView) {
            super(itemView);
            imageOffer = itemView.findViewById(R.id.imageOffer);
        }
    }
}
