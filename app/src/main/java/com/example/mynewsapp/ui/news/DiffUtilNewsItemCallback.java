package com.example.mynewsapp.ui.news;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.mynewsapp.data.NewsItem;

public class DiffUtilNewsItemCallback extends DiffUtil.ItemCallback<NewsItem> {
    @Override
    public boolean areItemsTheSame(@NonNull NewsItem oldItem, @NonNull NewsItem newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull NewsItem oldItem, @NonNull NewsItem newItem) {
        return oldItem.getId() == newItem.getId();
    }
}
