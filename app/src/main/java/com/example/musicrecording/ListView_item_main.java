package com.example.musicrecording;

import android.graphics.drawable.Drawable;


public class ListView_item_main {
    private Drawable iconDrawable;
    private String titleStr;
    private String dateStr;

    public void setIcon(Drawable icon){
        iconDrawable = icon;

    }

    public void setTitle(String title){
        titleStr = title;
    }

    public void setDate(String month, String day){
        dateStr = month + ":" + day;
    }

    public Drawable getIcon(){
        return this.iconDrawable;

    }

    public String getTitle(){
        return this.titleStr;
    }

    public String getDate(){
        return this.dateStr;
    }
}
