package com.example.manatrashidov.lw2.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Manat Rashidov on 4/25/2018.
 */

public class Comment {
    public
    @Getter
    @Setter
    String username;

    public
    @Getter
    @Setter
    String content;

    public Comment(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public Comment(JSONObject object) throws JSONException {
        this.username = object.getString("username");
        this.content = object.getString("message");
    }

    public static ArrayList<Comment> getFromJson(JSONObject object) throws JSONException {
        JSONArray array = object.getJSONArray("comments");
        ArrayList<Comment> comments = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            comments.add(new Comment(array.getJSONObject(i)));
        }
        return comments;
    }
}
