package com.example.manatrashidov.lw2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.manatrashidov.lw2.controllers.NewsAdapter;
import com.example.manatrashidov.lw2.models.MockData;
import com.example.manatrashidov.lw2.models.News;

import java.util.ArrayList;


public class NewsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        MockData md = new MockData(this);
        ArrayList<News> news = md.getMockData();
        NewsAdapter adapter = new NewsAdapter(this, news);
        ListView lw = findViewById(R.id.newsListView);
        lw.setAdapter(adapter);
    }
}
