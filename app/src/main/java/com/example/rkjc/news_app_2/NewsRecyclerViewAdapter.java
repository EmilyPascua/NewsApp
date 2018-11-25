package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.net.Uri;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsViewHolder>{

    Context mContext;
    private List<NewsItem> mNews;

    public NewsRecyclerViewAdapter(Context context, ArrayList<NewsItem> news){
        this.mContext = context;
        this.mNews = news;
    }

    @Override
    public NewsRecyclerViewAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.news_item, parent, false);

        NewsViewHolder viewHolder = new NewsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsRecyclerViewAdapter.NewsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public void setNews(List<NewsItem> news){
        this.mNews = news;
        notifyDataSetChanged();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView description;
        TextView date;
        ImageView newsImage;


        public NewsViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            date = (TextView) itemView.findViewById(R.id.date);
            newsImage = (ImageView) itemView.findViewById(R.id.article_image);


        }

        void bind(final int listIndex) {
            Picasso.with(mContext).load(mNews.get(listIndex).getUrlToImage()).into(newsImage);
            title.setText(mNews.get(listIndex).getTitle());
            description.setText(mNews.get(listIndex).getDescription());
            date.setText(mNews.get(listIndex).getPublishedAt());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String urlString = mNews.get(getAdapterPosition()).getUrl();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
            mContext.startActivity(browserIntent);
        }
    }
}