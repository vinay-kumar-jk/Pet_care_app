package com.example.petcare;

public class Pet {
    private String name;
    private int imageResourceId; // Drawable resource ID

    public Pet(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

