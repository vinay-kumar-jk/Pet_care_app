package com.example.petcare;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ViewPager2 viewPagerOffers;
    private TabLayout tabDots;
    private List<Integer> offerImages;
    private Handler sliderHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPagerOffers = view.findViewById(R.id.viewPagerOffers);
        tabDots = view.findViewById(R.id.tabDots);

        // Initialize offer images
        offerImages = new ArrayList<>();
        offerImages.add(R.drawable.offer1); // Replace with your drawable images
        offerImages.add(R.drawable.offer2);
        offerImages.add(R.drawable.img_11);

        // Set up adapter
        OfferAdapter adapter = new OfferAdapter(getContext(), offerImages);
        viewPagerOffers.setAdapter(adapter);

        // Set up dots indicator
        new TabLayoutMediator(tabDots, viewPagerOffers, (tab, position) -> {
            // This is where you can customize tab behavior if needed
        }).attach();

        // Auto-slide functionality
        sliderHandler = new Handler(Looper.getMainLooper());
        viewPagerOffers.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                // Reset the handler to avoid overlapping slides
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); // 3-second delay
            }
        });

        return view;
    }

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            if (viewPagerOffers.getAdapter() != null) {
                int nextItem = (viewPagerOffers.getCurrentItem() + 1) % offerImages.size();
                viewPagerOffers.setCurrentItem(nextItem, true);
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sliderHandler.removeCallbacks(sliderRunnable); // Clean up the handler
    }
}
