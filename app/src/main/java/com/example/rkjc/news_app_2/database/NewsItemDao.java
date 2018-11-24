package com.example.rkjc.news_app_2.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.rkjc.news_app_2.NewsItem;

import java.util.List;

@Dao
public interface NewsItemDao {

    @Query("SELECT * FROM news_table")
    LiveData<List<NewsItem>> loadAllNews();

    @Insert
    void insert(NewsItem newsItem);

    @Query("DELETE FROM news_table")
    void clearAll();
}
