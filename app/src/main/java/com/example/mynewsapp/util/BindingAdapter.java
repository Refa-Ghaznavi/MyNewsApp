package com.example.mynewsapp.util;

import android.content.Context;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.mynewsapp.R;

public class BindingAdapter {
    // here we create our custom binding adapter like so

    @androidx.databinding.BindingAdapter("glide_url")
    public static void loading(ImageView imageView,String url){
        // we will use glide library to load the image from a url


        Glide.with(imageView.getContext()).load(url).into(imageView);
        // now let's use this adapter in our xml file
    }

    @androidx.databinding.BindingAdapter("glide_circular")
    public static void loadUserImg(ImageView view,String url) {
        // we will use glide library to load the image from a url
        Glide.with(view.getContext()).load(url).circleCrop().into(view);
    }

    @androidx.databinding.BindingAdapter("set_background")
    public static void setBackground(ImageView view,String color) {

        switch (color){
            case "RED" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.red));
            break;
            case "BLACK" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.black));
            break;
            case "YELLOW" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.yellow));
            break;
            case "BLUE" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.blue));
            break;
            case "PURPLE" : view.setBackgroundColor(view.getContext().getResources().getColor(R.color.purple));
            break;

            default: view.setBackgroundColor(view.getContext().getResources().getColor(R.color.red));
        }

    }

    @androidx.databinding.BindingAdapter("set_checked")
    public static void toggleFav(ImageView view,Boolean isFav){
        if(isFav){
            view.setColorFilter(ContextCompat.getColor(view.getContext(),R.color.red));
        }
        else {
            view.setColorFilter(ContextCompat.getColor(view.getContext(),R.color.dark_icon_tint_color));
        }
    }

}
