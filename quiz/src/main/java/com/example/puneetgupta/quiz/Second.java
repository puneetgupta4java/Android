package com.example.puneetgupta.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Second extends AppCompatActivity {
    Button b2;
    RadioButton r5,r6,r7,r8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b2 = (Button)findViewById(R.id.button2);
        r5 = (RadioButton)findViewById(R.id.radioButton5);
        r6 = (RadioButton)findViewById(R.id.radioButton6);
        r7 = (RadioButton)findViewById(R.id.radioButton8);
        r8 = (RadioButton)findViewById(R.id.radioButton11);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r6.isChecked()){
                    ++MainActivity.score;
                }
                else{
                    --MainActivity.score;
                }
                Intent i2 = new Intent(Second.this,Fourth.class);
                startActivity(i2);
                finish();
            }
        });
    }
}
