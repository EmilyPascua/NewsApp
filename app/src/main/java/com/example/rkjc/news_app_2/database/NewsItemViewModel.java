package com.example.rkjc.news_app_2.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.rkjc.news_app_2.NewsItem;

import java.util.List;

public class NewsItemViewModel extends AndroidViewModel {

    private NewsRepository repository;
    private LiveData<List<NewsItem>> mAllNews;

    public NewsItemViewModel (@NonNull Application application) {
        super(application);
        repository = new NewsRepository(application);
        mAllNews = repository.getAllNews();
    }

    public LiveData<List<NewsItem>> getAllWords() {
        return mAllNews;
    }

    public void insert(NewsItem newsItem) {
        repository.insert(newsItem);
    }

    public void clearAll(){
        repository.clearAll();
    }

    public void populateDb(){
        repository.populateDb();
    }
}