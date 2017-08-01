package com.example.puneetgupta.project1;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Second extends AppCompatActivity {
    Button b4,b5,b6,b7,b8,b9;
    EditText e1,e2;
    TextView t1;
    TextToSpeech ts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        b9 = (Button)findViewById(R.id.button9);
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        t1 = (TextView)findViewById(R.id.textView);
        ts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                ts.setLanguage(Locale.ENGLISH);
                ts.setSpeechRate(0.5f);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);
                Integer i2 = Integer.parseInt(s2);
                Integer i3 = i1+i2;
                String s3 = Integer.toString(i3);
                s3 = "The result is : " + s3;
                t1.setText(s3);
                Toast.makeText(Second.this,s2,Toast.LENGTH_SHORT).show();
                ts.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);
                Integer i2 = Integer.parseInt(s2);
                Integer i3 = i1-i2;
                String s3 = Integer.toString(i3);
                s3 = "The result is : " + s3;
                t1.setText(s3);
                Toast.makeText(Second.this,s2,Toast.LENGTH_SHORT).show();
                ts.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);
                Integer i2 = Integer.parseInt(s2);
                Integer i3 = i1*i2;
                String s3 = Integer.toString(i3);
                s3 = "The result is : " + s3;
                t1.setText(s3);
                Toast.makeText(Second.this,s2,Toast.LENGTH_SHORT).show();
                ts.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                Integer i1 = Integer.parseInt(s1);
                Integer i2 = Integer.parseInt(s2);
                Integer i3 = i1/i2;
                String s3 = Integer.toString(i3);
                s3 = "The result is : " + s3;
                t1.setText(s3);
                Toast.makeText(Second.this,s2,Toast.LENGTH_SHORT).show();
                ts.speak(s3,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                t1.setText("");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Second.this,Third.class);
                startActivity(i2);
                finish();
            }
        });
    }
}
