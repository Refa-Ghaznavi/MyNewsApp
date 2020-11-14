package com.example.mynewsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mynewsapp.R;
import com.example.mynewsapp.data.FakeDataSource;
import com.example.mynewsapp.ui.news.DiffUtilNewsItemCallback;
import com.example.mynewsapp.ui.news.NewsListAdapter;

public class NewsListFragment extends Fragment {

    RecyclerView recyclerView;
    NewsListAdapter adapter;

    SwipeRefreshLayout swipeRefreshLayout;


    public NewsListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_list_news);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter = new NewsListAdapter(new DiffUtilNewsItemCallback());
        recyclerView.setAdapter(adapter);
        // we need a news list data to test the news recyclerview
        // I have already created a data class generate a random list of news item

        FakeDataSource fakeDataSource = new FakeDataSource();
        adapter.submitList(fakeDataSource.getFakeListNews());

        // let us instantiate the swiperefreshlayout we could use view binding, but i will use the classic findviewbyid mehod
        swipeRefreshLayout = view.findViewById(R.id.news_list_swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // for now i wil just simulate a refresh process
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // here we update the news list with new data
                        // i will just call a helper method to generate a new update list
                        adapter.submitList(fakeDataSource.getFakeUpdatedStaticListNews());
                        swipeRefreshLayout.setRefreshing(false);

                        // as you can see the list news updated successfully but the recyclerview does not notify the user
                        // about the new data to do that i will listen for new data change on the recyclerview and if there
                        // is any data added or changed i will scroll the rv to that data item position...

                        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                            @Override
                            public void onItemRangeInserted(int positionStart, int itemCount) {
                                super.onItemRangeInserted(positionStart, itemCount);
                                recyclerView.smoothScrollToPosition(positionStart);
                            }
                        });
                    }
                },1200);
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false);
    }
}