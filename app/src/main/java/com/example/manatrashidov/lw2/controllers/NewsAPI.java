package com.example.manatrashidov.lw2.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created by Manat Rashidov on 4/24/2018.
 */

public class NewsAPI {
    public static URL host;

    static {
        try {
            host = new URL("http://192.168.0.48:8080/news/");
        } catch (Exception ex) {
            host = null;
        }
    }

    public static JSONObject getNews(URL url) throws ExecutionException, InterruptedException {
        return new NewsDownloader().execute(url).get();
    }

    public static Bitmap getImage(@NonNull URL url) throws ExecutionException, InterruptedException {
        return new ImageDownloader().execute(url).get();
    }

    private static class NewsDownloader extends AsyncTask<URL, Void, JSONObject> {
        @Override
        protected JSONObject doInBackground(URL... urls) {
            JSONObject root = null;
            if (urls.length > 0) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) urls[0].openConnection();

                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStream is = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(is));
                        StringBuilder sBuilder = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            sBuilder.append(line);
                        }
                        root = (JSONObject) new JSONTokener(sBuilder.toString()).nextValue();
                        Log.i("info", root.toString());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return root;
        }
    }

    private static class ImageDownloader extends AsyncTask<URL, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(URL... urls) {
            Bitmap image = null;
            if (urls.length > 0) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) urls[0].openConnection();
                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStream iStream = connection.getInputStream();
                        image = BitmapFactory.decodeStream(iStream);
                    }
                } catch (Exception e) {
                    Log.e("error", e.getMessage());
                }

            }
            return image;
        }
    }


}
