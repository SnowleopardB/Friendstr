package com.example.friendstr;

import java.io.Serializable;

public class Friend implements Serializable {
    private int drawableId;
    private String name, bio;
    private float rating;

    public Friend(int drawableId, String name, String bio) {
        this.drawableId = drawableId;
        this.name = name;
        this.bio = bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "waw";
    }
}

