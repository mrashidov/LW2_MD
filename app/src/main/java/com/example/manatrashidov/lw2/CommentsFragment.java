package com.example.manatrashidov.lw2;


import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manatrashidov.lw2.controllers.CommentAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommentsFragment extends ListFragment {


    public CommentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comments, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CommentAdapter adapter = new CommentAdapter(getContext(), DetailsFragment.getMNews().getComments());
        setListAdapter(adapter);


    }
}
