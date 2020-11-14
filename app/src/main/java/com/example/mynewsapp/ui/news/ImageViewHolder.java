package com.example.mynewsapp.ui.news;

import android.view.View;

import androidx.annotation.NonNull;

import com.example.mynewsapp.data.NewsItem;
import com.example.mynewsapp.databinding.ItemNewsImageBinding;
import com.example.mynewsapp.databinding.ItemNewsTextBinding;

public class ImageViewHolder extends BaseViewHolder {

    ItemNewsImageBinding itemNewsImageBinding;

    public ImageViewHolder(@NonNull ItemNewsImageBinding itemNewsImageBinding) {
        super(itemNewsImageBinding.getRoot());
        this.itemNewsImageBinding = itemNewsImageBinding;
    }

    @Override
    public void binData(NewsItem item) {

        itemNewsImageBinding.setNewsItemImage(item);
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
