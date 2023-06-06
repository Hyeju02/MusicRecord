package com.example.musicrecording;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{


    ListView listView;
    ListViewAdapter adapter;
    Spinner spinnermood;

    ArrayAdapter<CharSequence> adapter1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //어뎁터 연결
        adapter = new ListViewAdapter();
        listView = (ListView) findViewById(R.id.List_Diary);
        listView.setAdapter(adapter);

        //무드 선택하면 무드 스피너, 달 선택하면 달 스피너
        adapter1 = ArrayAdapter.createFromResource(
                this,R.array.array_selectmood, android.R.layout.simple_dropdown_item_1line
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnermood = (Spinner)findViewById(R.id.Spinner_SelectMoodorMonth);
        spinnermood.setAdapter(adapter1);

        //DB
        DBManager dbmgr = new DBManager(this);
        SQLiteDatabase sdb = dbmgr.getReadableDatabase();

        //스피너
        spinnermood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                //Happy
                if (adapterView.getItemAtPosition(position).toString().equals("Happy")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (mood.equals("Happy")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Mellow
                if (adapterView.getItemAtPosition(position).toString().equals("Mellow")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (mood.equals("Mellow")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Sorrow

                if (adapterView.getItemAtPosition(position).toString().equals("Sorrow")){
                    int i = 0;
                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (mood.equals("Sorrow")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //SO-SO
                if (adapterView.getItemAtPosition(position).toString().equals("SO-SO")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (mood.equals("SO-SO")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }


                //Mad
                if (adapterView.getItemAtPosition(position).toString().equals("Mad")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (mood.equals("Mad")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Gloomy
                if (adapterView.getItemAtPosition(position).toString().equals("Gloomy")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (mood.equals("Gloomy")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }



                //여기서부터는 month


                //Jen
                if (adapterView.getItemAtPosition(position).toString().equals("Jen")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("01") || month.equals("1")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Feb
                if (adapterView.getItemAtPosition(position).toString().equals("Feb")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("02") || month.equals("2")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Mar
                if (adapterView.getItemAtPosition(position).toString().equals("Mar")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("03") || month.equals("3")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Apr
                if (adapterView.getItemAtPosition(position).toString().equals("Apr")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("04") || month.equals("4")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }


                //May
                if (adapterView.getItemAtPosition(position).toString().equals("May")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("05") || month.equals("5")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Jun
                if (adapterView.getItemAtPosition(position).toString().equals("Jun")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("06") || month.equals("6")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Jul
                if (adapterView.getItemAtPosition(position).toString().equals("Jul")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("07") || month.equals("7")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Aug
                if (adapterView.getItemAtPosition(position).toString().equals("Aug")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("08") || month.equals("8")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Sep
                if (adapterView.getItemAtPosition(position).toString().equals("Sep")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("09") || month.equals("9")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Oct
                if (adapterView.getItemAtPosition(position).toString().equals("Oct")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("10")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Nov
                if (adapterView.getItemAtPosition(position).toString().equals("Nov")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("11")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

                //Dec
                if (adapterView.getItemAtPosition(position).toString().equals("Dec")){
                    int i = 0;

                    adapter.cleanItem();

                    Cursor cursor = sdb.rawQuery("select * from music", null);
                    while (cursor.moveToNext()){


                        String year = cursor.getString(0);
                        String month = cursor.getString(1);
                        String day = cursor.getString(2);
                        String title = cursor.getString(3);
                        String singer = cursor.getString(4);
                        String mood = cursor.getString(5);
                        String url = cursor.getString(6);
                        String diary = cursor.getString(7);

                        if (month.equals("12")){
                            adapter.addItem(null, title, month, day);
                        }

                        i++;
                    }
                    listView.setAdapter(adapter);
                    cursor.close();
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        //다이어리 새로 작성하는 버튼
        ImageButton Btn_WriteDiary = (ImageButton) findViewById(R.id.Btn_WriteDiary);
        Btn_WriteDiary.setOnClickListener(this);

        //검색 버튼
        ImageButton Btn_search = (ImageButton) findViewById(R.id.Btn_MovetoSearch);
        Btn_search.setOnClickListener(this);

        //무드 버튼
        ImageButton Btn_Mood = (ImageButton) findViewById(R.id.Btn_HomeMood);
        Btn_Mood.setOnClickListener(this);

        //달 고르는 버튼
        ImageButton Btn_Month = (ImageButton) findViewById(R.id.Btn_HomeMonth);
        Btn_Month.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){


        switch (v.getId()) {
            case R.id.Btn_WriteDiary:
                Intent writediary = new Intent(this, WriteDiaryActivity.class);
                startActivity(writediary);
                break;

            case R.id.Btn_MovetoSearch:
                Intent searchpage = new Intent(this, SearchActivity.class);
                startActivity(searchpage);
                break;

            case R.id.Btn_HomeMonth:
                //month를 골랐을 때
                    adapter1 = ArrayAdapter.createFromResource(
                            this,R.array.array_selectmonth, android.R.layout.simple_dropdown_item_1line
                    );
                    adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    spinnermood = (Spinner)findViewById(R.id.Spinner_SelectMoodorMonth);
                    spinnermood.setAdapter(adapter1);

                break;
            case R.id.Btn_HomeMood:
                //mood를 골랐을 때
                adapter1 = ArrayAdapter.createFromResource(
                        this,R.array.array_selectmood, android.R.layout.simple_dropdown_item_1line
                );
                adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinnermood = (Spinner)findViewById(R.id.Spinner_SelectMoodorMonth);
                spinnermood.setAdapter(adapter1);

                break;

        }
    }





}