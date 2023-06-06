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

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListView_item_main> listViewItemMainArrayList = new ArrayList<ListView_item_main>();
    public ListViewAdapter(){}

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
            convertView = inflater.inflate(R.layout.homediarylist_item, parent, false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.textView2);

        ListView_item_main listViewItemMain = listViewItemMainArrayList.get(position);

        iconImageView.setImageDrawable(listViewItemMain.getIcon());
        titleTextView.setText(listViewItemMain.getTitle());
        dateTextView.setText(listViewItemMain.getDate());

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
        ListView_item_main item = new ListView_item_main();

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
