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

import com.example.manatrashidov.lw2.controllers.NewsAPI;
import com.example.manatrashidov.lw2.controllers.NewsAdapter;
import com.example.manatrashidov.lw2.models.News;

import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class DigestFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_digest, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        News selectedNews = (News) getListView().getItemAtPosition(position);
        intent.putExtra("newsId", selectedNews.getId());
        startActivity(intent);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            URL url = new URL("http://192.168.0.48:8080/news/digest");
            Log.w("info", "Conneting to string" + url.toString());
            JSONObject digest = NewsAPI.getNews(url);
            if (digest == null) {
                Log.e("error", "Digest is broken.");
            } else {
                ArrayList<News> news = News.getFromDigest(digest);
                NewsAdapter adapter = new NewsAdapter(getContext(), news);
                setListAdapter(adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
