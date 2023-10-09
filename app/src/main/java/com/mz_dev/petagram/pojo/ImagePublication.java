package com.mz_dev.petagram.pojo;

public class ImagePublication {
    private int image;
    private int rating;

    public ImagePublication(int image, int rating) {
        this.image = image;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public int getRating() {
        return rating;
    }
}
