package com.example.mynewsapp.ui.news;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.mynewsapp.R;
import com.example.mynewsapp.data.NewsItem;
import com.example.mynewsapp.databinding.ItemNewsImageBinding;
import com.example.mynewsapp.databinding.ItemNewsTextBinding;

public class NewsListAdapter extends ListAdapter<NewsItem,BaseViewHolder> {


    OnNewItemClickEvent listener;
    public static final int VIEWTYPE_NEWS_TEXT = 0;
    public static final int VIEWTYPE_NEWS_IMAGE = 1;
    public static final int VIEWTYPE_NEWS_VIDEO = 2;

    public interface OnNewItemClickEvent{
        void onItemTextClick();
        void onItemImageClick();
        void onItemLongClick();
    }

    public void setOnNewsItemClickListener(OnNewItemClickEvent listener){
        this.listener = listener;
    }

    public NewsListAdapter(@NonNull DiffUtil.ItemCallback<NewsItem> diffCallback) {
        super(diffCallback);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();

    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // based on the item viewType we create our viewHolder
        // we have two viewHolder for now : text view holder and image view holder
        // and do not forget that we are going to use data binding feature to bind our data in the viewHolder class
        // we need to configure our viewHolder so they can accept a binding layout like so....
        // now we can instantiate our viewHolder safely

        switch (viewType){
            case VIEWTYPE_NEWS_TEXT :
                ItemNewsTextBinding itemNewsTextBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news_text,parent,false);
                return new TextViewHolder(itemNewsTextBinding);

            case VIEWTYPE_NEWS_IMAGE :
                ItemNewsImageBinding itemNewsImageBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news_image,parent,false);
                return new ImageViewHolder(itemNewsImageBinding);

            default:
                ItemNewsTextBinding defaultItemNewsTextBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_news_text,parent,false);
                return new TextViewHolder(defaultItemNewsTextBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

        holder.binData(getItem(position));
    }
}
