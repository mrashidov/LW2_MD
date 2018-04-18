package com.example.manatrashidov.lw2.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manatrashidov.lw2.R;
import com.example.manatrashidov.lw2.models.News;

import java.util.ArrayList;


public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView thumbnail = convertView.findViewById(R.id.thumbnail);
        thumbnail.setImageBitmap(news.getImage());
        TextView headline = convertView.findViewById(R.id.newsHeadline);
        headline.setText(news.getHeadline());
        TextView preview = convertView.findViewById(R.id.newsPreview);
        preview.setText(news.getArticle());
        TextView published = convertView.findViewById(R.id.newsPublished);
        published.setText(news.getPublished());
        return convertView;
    }
}
