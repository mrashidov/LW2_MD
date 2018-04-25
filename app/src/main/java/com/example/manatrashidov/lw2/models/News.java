package com.example.manatrashidov.lw2.models;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.manatrashidov.lw2.controllers.NewsAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import lombok.Getter;
import lombok.Setter;

public class News {

    @Getter
    @Setter
    private Integer id;
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
    @Getter
    @Setter
    private ArrayList<Comment> comments;


    public News(String headline, String published, String article, Bitmap image) {
        this.headline = headline;
        this.published = published;
        this.image = image;
        this.article = article;
    }

    public News(JSONObject object) throws JSONException,
            ExecutionException, InterruptedException {
        id = object.getInt("id");
        headline = object.getString("title");
        published = object.getString("publicationDate");
        String url = object.getString("imageUrl");
        if (url.equals("null")) {
            image = null;
        } else {
            try {
                image = NewsAPI.getImage(new URL(url));
            } catch (MalformedURLException ex) {
                image = null;
            }
        }
        article = object.getString("text");
        if (object.has("comments")) {
            comments = Comment.getFromJson(object);
        }

    }

    public static ArrayList<News> getFromDigest(JSONObject object) throws JSONException,
            InterruptedException, ExecutionException, MalformedURLException {
        ArrayList<News> news = null;

        JSONArray array = object.getJSONArray("content");
        news = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            news.add(new News(array.getJSONObject(i)));
            Log.i("info", "got!");
        }
        Log.i("info", "getFromDigest got " + ((news != null) ? news.size() : "null").toString());
        return news;
    }
}
