package com.example.mynewsapp.ui.news;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.mynewsapp.data.NewsItem;
import com.example.mynewsapp.databinding.ItemNewsImageBinding;
import com.example.mynewsapp.databinding.ItemNewsTextBinding;

public class TextViewHolder extends BaseViewHolder {

    ItemNewsTextBinding itemNewsTextBinding;

    public TextViewHolder(@NonNull ItemNewsTextBinding itemNewsTextBinding) {
        super(itemNewsTextBinding.getRoot());
        this.itemNewsTextBinding = itemNewsTextBinding;
    }

    @Override
    public void binData(NewsItem item) {
        itemNewsTextBinding.setNewsItemText(item);
    }

    @Override
    public ItemNewsTextBinding getItemNewsTextBinding() {
        return null;
    }

    @Override
    public ItemNewsImageBinding getItemNewsImageBinding() {
        return null;
    }
}
