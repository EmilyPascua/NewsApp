package com.example.rkjc.news_app_2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

import java.util.ArrayList;

public final class JsonUtils {
    public static ArrayList<NewsItem> parseNews(String JSONString){
        ArrayList<NewsItem> newsList = new ArrayList<>();
        Log.d("newsItem",JSONString);

        try {
            JSONObject mainJSONObject = new JSONObject(JSONString);
            JSONArray items = mainJSONObject.getJSONArray("articles");

            for(int i = 0; i < items.length(); i++){
                JSONObject item = items.getJSONObject(i);
                String author = item.getString("author");
                String title = item.getString("title");
                String description = item.getString("description");
                String url = item.getString("url");
                String urlToImage = item.getString("urlToImage");
                String publishedAt = item.getString("publishedAt");

                newsList.add(new NewsItem(author, title, url, description, urlToImage, publishedAt));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsList;
    }
}
