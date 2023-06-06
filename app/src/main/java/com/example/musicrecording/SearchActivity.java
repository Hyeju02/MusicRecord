package com.example.musicrecording;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SearchActivity extends Activity implements View.OnClickListener {

    TextView searchlist;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        searchlist =  (TextView) findViewById(R.id.search_textview);

        //홈으로 돌아가는 버튼
        ImageButton Btn_backtohome = (ImageButton) findViewById(R.id.Btn_BF_toHome3);
        Btn_backtohome.setOnClickListener(this);

        //검색 버튼
        ImageButton Btn_search = (ImageButton) findViewById(R.id.Btn_Search);
        Btn_search.setOnClickListener(this);



    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.Btn_BF_toHome3:
                onBackPressed();
                finish();
                break;

            case R.id.Btn_Search:
                //검색
                EditText searchname = findViewById(R.id.Edit_SearchKey);
                String[] searchkey = searchname.getText().toString().split(" ");

                int i=0;

                try {
                    DBManager dbmgr = new DBManager(this);
                    SQLiteDatabase sdb = dbmgr.getReadableDatabase();
                    Cursor cursor = sdb.rawQuery("select '%s' from music", searchkey);

                    while (cursor.moveToNext()){

                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);


                        searchlist.append(title + "\n");
                        searchlist.append(singer + "\n");

                        i++;


                    }
                    cursor.close();
                    dbmgr.close();
                } catch (SQLiteException e){
                    searchlist.append("DB ERROR!!");
                }
                if (i==0) {
                    searchlist.append("No information!!\n");
                }

        }
    }
}
