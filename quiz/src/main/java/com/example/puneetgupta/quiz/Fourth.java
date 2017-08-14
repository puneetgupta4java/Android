package com.example.puneetgupta.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Fourth extends AppCompatActivity {
    RadioButton r9,r10,r11,r12;
    Button b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        b6 = (Button)findViewById(R.id.button5);
        r9 = (RadioButton)findViewById(R.id.radioButton7);
        r10 = (RadioButton)findViewById(R.id.radioButton9);
        r11 = (RadioButton)findViewById(R.id.radioButton10);
        r12 = (RadioButton)findViewById(R.id.radioButton12);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r11.isChecked()){
                    ++MainActivity.score;
                }
                else{
                    --MainActivity.score;
                }
                Intent i10 = new Intent(Fourth.this,Third.class);
                startActivity(i10);
                finish();
            }
        });
    }
}
