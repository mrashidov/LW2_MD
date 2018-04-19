package com.example.manatrashidov.lw2;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.manatrashidov.lw2.controllers.NewsAdapter;
import com.example.manatrashidov.lw2.models.MockData;
import com.example.manatrashidov.lw2.models.News;

import java.util.ArrayList;

import lombok.Getter;

public class DigestFragment extends ListFragment {
    @Getter
    private static News mSelectedNews;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<News> news = new MockData(getContext()).getMockData();
        NewsAdapter adapter = new NewsAdapter(getContext(), news);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_digest, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        mSelectedNews = (News) getListView().getItemAtPosition(position);
        Log.w("WOW", "Selected news: " + mSelectedNews.getHeadline());
        startActivity(intent);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
