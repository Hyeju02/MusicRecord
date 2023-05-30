package com.example.musicrecording;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends Activity implements View.OnClickListener {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        //홈으로 돌아가는 버튼
        Button Btn_backtohome = (Button) findViewById(R.id.Btn_BF_toHome3);
        Btn_backtohome.setOnClickListener(this);

        //검색 버튼
        Button Btn_search = (Button) findViewById(R.id.Btn_Search);
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
                String searchkey = searchname.getText().toString();

                /*int i=0;

                try {
                    DBManager dbmgr = new DBManager(this);
                    SQLiteDatabase sdb = dbmgr.getReadableDatabase();
                    Cursor cursor = sdb.rawQuery("select searchkey from music", null);

                    while (cursor.moveToNext()){

                        String nationname = cursor.getString(0);
                        String gender = cursor.getString(1);
                        String sms = cursor.getString(2);
                        String interest = cursor.getString(3);

                        tv_list.append(nationname + "\n");
                        tv_list.append(gender + "\n");
                        tv_list.append(sms +"\n");
                        tv_list.append(interest +"\n\n");

                        i++;


                    }
                    cursor.close();
                    dbmgr.close();
                } catch (SQLiteException e){
                    tv_list.append("DB ERROR!!");
                }
                if (i==0) {
                    tv_list.append("No information!!\n");
                }*/

        }
    }
}
