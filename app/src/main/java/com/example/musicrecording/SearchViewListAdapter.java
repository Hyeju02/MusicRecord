package com.example.musicrecording;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchViewListAdapter extends BaseAdapter {

    private ArrayList<ListView_item_search> listViewItemMainArrayList = new ArrayList<ListView_item_search>();
    public SearchViewListAdapter(){}

    @Override
    public  int getCount(){
        return listViewItemMainArrayList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.searchlayout_item, parent, false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.searchimageview);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.searchtitle);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.searchdate);

        ListView_item_search listViewItemSearch = listViewItemMainArrayList.get(position);

        iconImageView.setImageDrawable(listViewItemSearch.getIcon());
        titleTextView.setText(listViewItemSearch.getTitle());
        dateTextView.setText(listViewItemSearch.getDate());

        return convertView;
    }

    @Override
    public  long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position){
        return listViewItemMainArrayList.get(position).getTitle();
    }


    public void addItem(Drawable icon, String title, String month, String day){
        ListView_item_search item = new ListView_item_search();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDate(month, day);

        listViewItemMainArrayList.add(item);
    }

    //아이템을 초기화
    public void cleanItem(){
        listViewItemMainArrayList.clear();
    }
}
