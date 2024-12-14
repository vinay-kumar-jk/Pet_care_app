package com.example.petcare;

import android.app.AlertDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFragment extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton addAppointmentButton;
    private AppointmentAdapter adapter;
    private List<Appointment> appointmentList;
    private com.example.appointments.AppointmentDatabaseHelper dbHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

        recyclerView = view.findViewById(R.id.rvAppointments);
        addAppointmentButton = view.findViewById(R.id.btnAddAppointment);

        // Initialize the database helper
        dbHelper = new com.example.appointments.AppointmentDatabaseHelper(getContext());

        // Load appointments from database
        appointmentList = dbHelper.getAllAppointments();
        adapter = new AppointmentAdapter(appointmentList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Add button click listener
        addAppointmentButton.setOnClickListener(v -> {
            View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_appointment, null);

            EditText etPetName = dialogView.findViewById(R.id.etPetName);
            EditText etAppointmentType = dialogView.findViewById(R.id.etAppointmentType);
            EditText etDate = dialogView.findViewById(R.id.etDate);
            EditText etTime = dialogView.findViewById(R.id.etTime);
            EditText etLocation = dialogView.findViewById(R.id.etLocation);

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Add Appointment");
            builder.setView(dialogView);

            builder.setPositiveButton("Save", (dialog, which) -> {
                String petName = etPetName.getText().toString();
                String appointmentType = etAppointmentType.getText().toString();
                String date = etDate.getText().toString();
                String time = etTime.getText().toString();
                String location = etLocation.getText().toString();

                if (petName.isEmpty() || appointmentType.isEmpty() || date.isEmpty() || time.isEmpty() || location.isEmpty()) {
                    Toast.makeText(getContext(), "All fields are required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Appointment newAppointment = new Appointment(petName, appointmentType, date, time, location, "Upcoming");

                // Save to database
                dbHelper.addAppointment(newAppointment);

                // Update the RecyclerView
                appointmentList.add(newAppointment);
                adapter.notifyItemInserted(appointmentList.size() - 1);

                Toast.makeText(getContext(), "Appointment added!", Toast.LENGTH_SHORT).show();
            });

            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
            builder.create().show();
        });





        return view;
    }
}
