package com.example.musicrecording;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WriteDiaryActivity extends Activity implements View.OnClickListener {

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.writediary_activity);

        Button Btn_BF_toHome = (Button) findViewById(R.id.Btn_BF_toHome);
        Btn_BF_toHome.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.Btn_BF_toHome:
                Intent home = new Intent(this, MainActivity.class);
                startActivity(home);
        }
    }
}
