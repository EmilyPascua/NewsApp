package com.example.rkjc.news_app_2;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;

import com.example.rkjc.news_app_2.autosync.ScheduleUtils;
import com.example.rkjc.news_app_2.database.NewsItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Create an instance of ViewModel
    private NewsItemViewModel newsItemViewModel;

    private ArrayList<NewsItem> newsItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.news_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NewsRecyclerViewAdapter adapter = new NewsRecyclerViewAdapter(this, newsItems);
        recyclerView.setAdapter(adapter);

        ScheduleUtils.scheduleRefresh(this);

        newsItemViewModel = ViewModelProviders.of(this).get(NewsItemViewModel.class);
        //Observer
        newsItemViewModel.getAllWords().observe(this, new Observer<List<NewsItem>>() {
            @Override
            public void onChanged(@Nullable List<NewsItem> newsItems) {
                //Data
                adapter.setNews(newsItems);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            newsItemViewModel.populateDb();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}