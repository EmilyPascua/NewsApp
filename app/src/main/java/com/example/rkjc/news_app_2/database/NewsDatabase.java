package com.example.rkjc.news_app_2.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.rkjc.news_app_2.NewsItem;

@Database(entities = {NewsItem.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {
    public abstract NewsItemDao newsItemDao();

    private static NewsDatabase instance;

    static NewsDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (NewsDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "news_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }
}

