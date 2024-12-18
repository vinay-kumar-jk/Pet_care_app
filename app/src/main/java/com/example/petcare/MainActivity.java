package com.example.petcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    ImageButton ab;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ab = findViewById(R.id.accountButton);

        // Load the default Home fragment
        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
        }

        // Set click listeners for navigation buttons
        findViewById(R.id.StoreLinearLayout).setOnClickListener(v -> replaceFragment(new Store()));
        findViewById(R.id.homeLinearLayout).setOnClickListener(v -> replaceFragment(new HomeFragment()));
        findViewById(R.id.adoptLinearLayout).setOnClickListener(v -> replaceFragment(new AdoptFragment()));
        findViewById(R.id.appointmentLinearLayout).setOnClickListener(v -> replaceFragment(new AppointmentFragment()));
    }

    // Helper method to replace the current fragment
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }


    public void nn(View view) {
        Intent intent=new Intent(getApplicationContext(),AccountActivity.class);
        startActivity(intent);
    }
}