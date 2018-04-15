package com.example.manatrashidov.lw2;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Manat Rashidov on 4/15/2018.
 */

public class MockData {
    private Context context;

    public MockData(Context context) {
        this.context = context;
    }

    public ArrayList<News> getMockData() {
        ArrayList<News> tmp = new ArrayList<>();
        String news_article = context.getResources().getString(R.string.placeholder_news);
        for (int i = 0; i < 10; i++) {
            tmp.add(new News("First News", "today", news_article, R.drawable.placeholder100x100));
        }
        return tmp;
    }
}
