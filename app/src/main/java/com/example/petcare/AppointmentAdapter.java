package com.example.petcare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder> {

    private List<Appointment> appointmentList;

    public AppointmentAdapter(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appointment, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        Appointment appointment = appointmentList.get(position);
        holder.petName.setText(appointment.getPetName());
        holder.appointmentType.setText(appointment.getAppointmentType());
        holder.dateTime.setText(appointment.getDate() + ", " + appointment.getTime());
        holder.location.setText(appointment.getLocation());
        holder.status.setText(appointment.getStatus());
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    static class AppointmentViewHolder extends RecyclerView.ViewHolder {
        TextView petName, appointmentType, dateTime, location, status;

        public AppointmentViewHolder(@NonNull View itemView) {
            super(itemView);
            petName = itemView.findViewById(R.id.tvPetName);
            appointmentType = itemView.findViewById(R.id.tvAppointmentType);
            dateTime = itemView.findViewById(R.id.tvDateTime);
            location = itemView.findViewById(R.id.tvLocation);
            status = itemView.findViewById(R.id.tvStatus);
        }
    }
}
