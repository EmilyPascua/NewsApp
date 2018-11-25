package com.example.rkjc.news_app_2.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.rkjc.news_app_2.utils.JsonUtils;
import com.example.rkjc.news_app_2.utils.NetworkUtils;
import com.example.rkjc.news_app_2.NewsItem;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsRepository {
    private NewsItemDao newsItemDao;
    private LiveData<List<NewsItem>> allNews;

    public NewsRepository(Application application) {
        NewsDatabase database = NewsDatabase.getDatabase(application);
        newsItemDao = database.newsItemDao();
        allNews = newsItemDao.loadAllNews();
    }

    public void insert(NewsItem newsItem) {
        new InsertNewsItemAsyncTask(newsItemDao).execute(newsItem);
    }

    public void clearAll() {
        new ClearAllNewsAsyncTask(newsItemDao).execute();
    }

    public void populateDb() {
        new PopulateDbAsyncTask(newsItemDao).execute();
    }

    public LiveData<List<NewsItem>> getAllNews() {
        return allNews;
    }

    private static class InsertNewsItemAsyncTask extends AsyncTask<NewsItem, Void, Void> {
        private NewsItemDao newsItemDao;

        private InsertNewsItemAsyncTask(NewsItemDao newsItemDao) {
            this.newsItemDao = newsItemDao;
        }

        @Override
        protected Void doInBackground(NewsItem... newsItems) {
            newsItemDao.insert(newsItems[0]);
            return null;
        }
    }

    private static class ClearAllNewsAsyncTask extends AsyncTask<Void, Void, Void> {
        private NewsItemDao newsItemDao;

        private ClearAllNewsAsyncTask(NewsItemDao newsItemDao) {
            this.newsItemDao = newsItemDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            newsItemDao.clearAll();
            return null;
        }
    }

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        ArrayList<NewsItem> newsItems = new ArrayList<>();

        private NewsItemDao newsItemDao;

        private PopulateDbAsyncTask(NewsItemDao newsItemDao) {
            this.newsItemDao = newsItemDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String source = "the-next-web";
            String sortBy = "latest";
            URL newsRequestUrl = NetworkUtils.buildUrl(sortBy, source);
            try {
                String jsonNewsResponse = NetworkUtils
                        .getResponseFromHttpUrl(newsRequestUrl);

                newsItemDao.clearAll();
                newsItems = JsonUtils.parseNews(jsonNewsResponse);
                for (NewsItem news : newsItems) {
                    newsItemDao.insert(news);
                }
                return null;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
