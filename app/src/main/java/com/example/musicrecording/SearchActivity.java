package com.example.musicrecording;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

public class SearchActivity extends Activity implements View.OnClickListener {


    ListView listView;
    ListViewAdapter adapter;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);


        //홈으로 돌아가는 버튼
        ImageButton Btn_backtohome = (ImageButton) findViewById(R.id.Btn_BF_toHome3);
        Btn_backtohome.setOnClickListener(this);

        //검색 버튼
        ImageButton Btn_search = (ImageButton) findViewById(R.id.Btn_Search);
        Btn_search.setOnClickListener(this);

        //어뎁터 연결
        adapter = new ListViewAdapter();
        listView = (ListView) findViewById(R.id.List_Search);
        listView.setAdapter(adapter);

        //리스트 아이템 클릭했을 때
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                //클릭한 타이틀 이름
                String title = (String) parent.getItemAtPosition(position).toString();

                //intent로 상세페이지에 정보 넘겨줌
                Intent intentsearch = new Intent(v.getContext(), ShowDiaryActivity.class);
                intentsearch.putExtra("selecttitle", title);
                startActivity(intentsearch);
            }

        });



    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.Btn_BF_toHome3:
                onBackPressed();
                finish();
                break;

            case R.id.Btn_Search:
                //검색
                adapter.cleanItem();
                EditText searchname = findViewById(R.id.Edit_SearchKey);
                String searchkey = searchname.getText().toString();  // 사용자로부터 입력 받는 값



                try {

                        DBManager dbmgr = new DBManager(this);
                        SQLiteDatabase db = dbmgr.getReadableDatabase();
                        String sql = "SELECT * FROM music WHERE title LIKE ? OR singer LIKE ?";
                        String[] selectionArgs = {"%" + searchkey + "%", "%" + searchkey + "%"};
                        Cursor cursor = db.rawQuery(sql, selectionArgs);


                        while (cursor.moveToNext()) {

                            String year = cursor.getString(0);
                            String month = cursor.getString(1);
                            String day = cursor.getString(2);
                            String title = cursor.getString(3);
                            String singer = cursor.getString(4);
                            String mood = cursor.getString(5);
                            String url = cursor.getString(6);
                            String diary = cursor.getString(7);
                            String cover = cursor.getString(8);

                            int moodnum = Integer.parseInt(cover);
                            //cover db 값에 따라 커버 사진 설정
                            switch (moodnum) {
                                case 1:
                                    adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood1), title, month, day);
                                    break;
                                case 2:
                                    adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood2), title, month, day);
                                    break;
                                case 3:
                                    adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood3), title, month, day);
                                    break;
                                case 4:
                                    adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood4), title, month, day);
                                    break;
                                case 5:
                                    adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood5), title, month, day);
                                    break;
                                case 6:
                                    adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood6), title, month, day);
                                    break;
                                case 7:
                                    adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood7), title, month, day);
                                    break;
                                case 8:
                                    adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood8), title, month, day);
                                    break;
                                default:
                                    if (mood.equals("Happy")) {
                                        adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood1), title, month, day);
                                    } else if (mood.equals("Mellow")) {
                                        adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood2), title, month, day);
                                    } else if (mood.equals("SO-SO")) {
                                        adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood3), title, month, day);
                                    } else if (mood.equals("Sorrow")) {
                                        adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood5), title, month, day);
                                    } else if (mood.equals("Gloomy")) {
                                        adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood6), title, month, day);
                                    } else if (mood.equals("Mad")) {
                                        adapter.addItem(ContextCompat.getDrawable(SearchActivity.this, R.drawable.default_covermood8), title, month, day);
                                    }
                                    break;
                            }
                        }
                        listView.setAdapter(adapter);
                        cursor.close();
                    } catch (SQLException e) {}


        }
    }
}
