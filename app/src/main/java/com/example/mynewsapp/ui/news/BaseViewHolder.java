package com.example.mynewsapp.ui.news;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynewsapp.data.NewsItem;
import com.example.mynewsapp.databinding.ItemNewsImageBinding;
import com.example.mynewsapp.databinding.ItemNewsTextBinding;

abstract class BaseViewHolder extends RecyclerView.ViewHolder {


    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void binData(NewsItem item);

    // we will need these methods for shared view animation purpose
    public abstract ItemNewsTextBinding getItemNewsTextBinding();
    public abstract ItemNewsImageBinding getItemNewsImageBinding();
}
