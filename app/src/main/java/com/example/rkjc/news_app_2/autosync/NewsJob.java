package com.example.rkjc.news_app_2.autosync;

import android.os.AsyncTask;

import com.example.rkjc.news_app_2.database.NewsItemViewModel;
import com.example.rkjc.news_app_2.utils.NotificationUtils;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

import java.util.Calendar;
import java.util.Date;

public class NewsJob extends JobService {
    static AsyncTask mBackgroundTask;
    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        final NewsItemViewModel news = new NewsItemViewModel(getApplication());
        mBackgroundTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                NotificationUtils.notifyUser(getApplicationContext());
                news.populateDb();
                return null;
            }

            @Override
            protected void onPreExecute() {}
        };
        mBackgroundTask.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        return true;
    }
}