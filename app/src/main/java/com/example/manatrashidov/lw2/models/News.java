package com.example.manatrashidov.lw2.models;

import android.graphics.Bitmap;

import lombok.Getter;
import lombok.Setter;

public class News {
    @Getter
    @Setter
    private String headline;
    @Getter
    @Setter
    private String published;
    @Getter
    @Setter
    private Bitmap image;
    @Getter
    @Setter
    private String article;


    public News(String headline, String published, String article, Bitmap image) {
        this.headline = headline;
        this.published = published;
        this.image = image;
        this.article = article;
    }


}
