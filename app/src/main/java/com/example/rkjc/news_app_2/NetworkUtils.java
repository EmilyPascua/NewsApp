package com.example.rkjc.news_app_2;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import android.util.Log;

public final class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    //This is the base_url
    private static final String NEWS_BASE_URL = "https://newsapi.org/v1/articles";

    //the API Key
    private static final String API_Key = "395727b4b74c48d79ca2c35143b0114d";

    //query_parameters
    final static String API_KEY_PARAM = "apiKey";
    final static String SOURCE_PARAM = "source";
    final static String SORTBY_PARAM = "sortBy";

    //Build the URL using Uri
    public static URL buildUrl(String sortQuery, String sourceQuery) {
        // URL query used to open the New's API
        Uri builtUri = Uri.parse(NEWS_BASE_URL).buildUpon()
                .appendQueryParameter(SOURCE_PARAM, sourceQuery)
                .appendQueryParameter(SORTBY_PARAM, sortQuery)
                .appendQueryParameter(API_KEY_PARAM, API_Key)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
