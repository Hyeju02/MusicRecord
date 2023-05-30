package com.example.musicrecording;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SelectCover_Activity extends Activity implements View.OnClickListener {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcoverimg_activity);

        //다이어리 쓰는 곳으로 돌아가는 이전 버튼
        Button Btn_ToWriteDiary = (Button) findViewById(R.id.Btn_BF_toWriteDiary);
        Btn_ToWriteDiary.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.Btn_BF_toWriteDiary:
                Intent last = new Intent(this, WriteDiaryActivity.class);
                //이전 페이지로 돌아가게 해야 됨
                startActivity(last);
                finish();

        }

    }
}
