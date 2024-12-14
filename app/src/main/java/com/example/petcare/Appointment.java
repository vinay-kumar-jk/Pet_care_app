package com.example.petcare;

public class Appointment {
    private String petName;
    private String appointmentType;
    private String date;
    private String time;
    private String location;
    private String status;

    public Appointment(String petName, String appointmentType, String date, String time, String location, String status) {
        this.petName = petName;
        this.appointmentType = appointmentType;
        this.date = date;
        this.time = time;
        this.location = location;
        this.status = status;
    }

    public String getPetName() {
        return petName;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }
}
