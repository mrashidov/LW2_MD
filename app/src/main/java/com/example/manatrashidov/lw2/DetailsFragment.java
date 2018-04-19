package com.example.manatrashidov.lw2;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manatrashidov.lw2.models.News;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }

    private ImageView mImage;
    private TextView mTitle;
    private TextView mPublished;
    private TextView mText;

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
        News news = DigestFragment.getMSelectedNews();
        mImage.setImageBitmap(news.getImage());
        mTitle.setText(news.getHeadline());
        mPublished.setText(news.getPublished());
        mText.setText(news.getArticle());
        Log.w("WOW", news.getArticle());

    }
}
