package com.example.manatrashidov.lw2.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.manatrashidov.lw2.R;
import com.example.manatrashidov.lw2.models.Comment;

import java.util.ArrayList;

/**
 * Created by Manat Rashidov on 4/25/2018.
 */

public class CommentAdapter extends ArrayAdapter<Comment> {

    public CommentAdapter(Context context, ArrayList<Comment> comments) {
        super(context, 0, comments);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.comment_list_item, parent, false);
        }
        TextView username = convertView.findViewById(R.id.commentUsername);
        TextView content = convertView.findViewById(R.id.commentContent);
        username.setText(comment.username);
        content.setText(comment.content);
        return convertView;
    }

}
