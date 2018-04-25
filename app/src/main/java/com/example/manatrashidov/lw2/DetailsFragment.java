package com.example.manatrashidov.lw2;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manatrashidov.lw2.controllers.NewsAPI;
import com.example.manatrashidov.lw2.models.News;

import org.json.JSONObject;

import java.net.URL;

import lombok.Getter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    private ImageView mImage;
    private TextView mTitle;
    private TextView mPublished;
    private TextView mText;
    @Getter
    private static News mNews;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mImage = (ImageView) getActivity().findViewById(R.id.detailImage);
        mTitle = (TextView) getActivity().findViewById(R.id.detailsTitle);
        mPublished = (TextView) getActivity().findViewById(R.id.detailsPublished);
        mText = (TextView) getActivity().findViewById(R.id.detailsText);
        int newsId = getActivity().getIntent().getExtras().getInt("newsId");
        try {
            JSONObject jNews = NewsAPI.getNews(new URL(NewsAPI.host,
                    String.format("article?newsId=%d", newsId)));
            mNews = new News(jNews);
            if (mNews.getImage() != null) {
                mImage.setImageBitmap(mNews.getImage());
            }
            mTitle.setText(mNews.getHeadline());
            mPublished.setText(mNews.getPublished());
            mText.setText(mNews.getArticle());
            CommentsFragment fComments = new CommentsFragment();
            FragmentTransaction fragmentTransaction = getActivity().
                    getFragmentManager().
                    beginTransaction();
            fragmentTransaction.replace(R.id.commentsPlaceholder, fComments);
            fragmentTransaction.commit();
        } catch (Exception ex) {
            Log.e("error", ex.getMessage());
        }

    }
}
