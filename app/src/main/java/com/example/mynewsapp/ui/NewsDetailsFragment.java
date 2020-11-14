package com.example.mynewsapp.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mynewsapp.R;
import com.example.mynewsapp.data.FakeDataSource;
import com.example.mynewsapp.data.NewsItem;
import com.example.mynewsapp.databinding.FragmentNewsDetailsBinding;

public class NewsDetailsFragment extends Fragment {


    public NewsDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentNewsDetailsBinding fragmentNewsDetailsBinding =
                DataBindingUtil.inflate(LayoutInflater.from(getContext()),R.layout.fragment_news_details,container,false);

        // we need to test if databinding works fine : so we need a news item
        // we can get a random item from the datasource class

        FakeDataSource fakeDataSource = new FakeDataSource();
        NewsItem item = fakeDataSource.generateRandomNewsItem();

        item.setFav(true);
        fragmentNewsDetailsBinding.setNewsItemData(item);

        return fragmentNewsDetailsBinding.getRoot();

        // now let us test this out, for nwo we can not access this fragment
        // i will same changes to navigation graph so i can display this fragment...
    }
}