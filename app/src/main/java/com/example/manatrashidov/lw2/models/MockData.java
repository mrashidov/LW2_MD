package com.example.manatrashidov.lw2.models;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.example.manatrashidov.lw2.R;

import java.util.ArrayList;

public class MockData {
    private Context context;

    public MockData(Context context) {
        this.context = context;
    }

    public ArrayList<News> getMockData() {
        ArrayList<News> tmp = new ArrayList<>();
        String news_article = context.getResources().getString(R.string.placeholder_news);
        for (int i = 0; i < 10; i++) {
            tmp.add(new News("First News", "today", news_article, BitmapFactory.decodeResource(context.getResources(), R.drawable.placeholder100x100)));
        }
        return tmp;
    }
}
