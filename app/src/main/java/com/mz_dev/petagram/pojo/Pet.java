package com.mz_dev.petagram.pojo;

import android.content.ContentValues;

import com.mz_dev.petagram.dataBase.ConstDataBase;

import java.io.Serializable;

public class Pet implements Serializable {
    private int id;
    private String name;
    private int image;
    private int rating;

    public Pet(int id, String name, int image, int rating) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.rating = rating;
    }

    public Pet(String name, int image, int rating) {
        this.name = name;
        this.image = image;
        this.rating = rating;
    }

    public Pet() {

    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(ConstDataBase.TABLE_PETS_NAME, name);
        values.put(ConstDataBase.TABLE_PETS_IMAGE, image);
        return values;
    }
}
