package de.btu.tutorialapp;

import android.graphics.drawable.Drawable;

public class WorkInstruction {
    private String description;
    private Drawable image;

    public WorkInstruction(String description, Drawable image) {
        this.description = description;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public Drawable getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}

